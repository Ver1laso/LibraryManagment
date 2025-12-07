package dev.jlprisan.LibraryManagment.Controller;


import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import dev.jlprisan.LibraryManagment.Repository.UserRepository;
import dev.jlprisan.LibraryManagment.Security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    PasswordEncoder pwEncoder;
    JwtUtil jwtUtil;

    public AuthController( AuthenticationManager authenticationManager, UserRepository userRepository,
            PasswordEncoder pwEncoder,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.pwEncoder = pwEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody UserEntity user) {
        Authentication authencation = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
//        UserDetails userDetails = (UserDetails) authencation.getPrincipal();
        return jwtUtil.generateToken(authencation.getName());
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody UserEntity user){
        if(userRepository.existsByEmail(user.getEmail())){
            return "Error: Email is already in use!";
        }
        UserEntity newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(pwEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return "User registered successfully!";
    }
}
