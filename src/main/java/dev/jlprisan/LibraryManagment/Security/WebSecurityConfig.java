package dev.jlprisan.LibraryManagment.Security;

import dev.jlprisan.LibraryManagment.Service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final CustomUserDetailService userDetailService;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final JwtUtil jwtUtil;

    public WebSecurityConfig (
            CustomUserDetailService userDetailService,
            AuthEntryPointJwt unauthorizedHandler,
            JwtUtil jwtUtil
    ) {
        this.userDetailService = userDetailService;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(jwtUtil, userDetailService );
    }
    @Bean
    public AuthenticationManager authenticationManagerBean(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(java.util.List.of("http://localhost:8080"));
                    corsConfiguration.setAllowedMethods(java.util.List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    corsConfiguration.setAllowedHeaders(java.util.List.of("*"));
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }))
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(sessionManagment ->
                        sessionManagment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
//                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/test/all").permitAll()
                                .anyRequest().authenticated())
//                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//                .anyRequest().authenticated();

        //Add the JWT token filter before the UnamePasswordAuthenticationFilter
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
