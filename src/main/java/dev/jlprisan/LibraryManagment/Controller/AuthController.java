package dev.jlprisan.LibraryManagment.Controller;


import dev.jlprisan.LibraryManagment.DTO.LoginRequestDTO;
import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import dev.jlprisan.LibraryManagment.Repository.UserRepository;
import dev.jlprisan.LibraryManagment.Security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
/**
//    @PostMapping("/signin")
    @PostMapping("/login")
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
 **/
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {

        try{
            System.out.println("Login attempt for email: " + loginRequest.getEmail());

            System.out.println("=== LOGIN ATTEMPT ===");
            System.out.println("Email: " + loginRequest.getEmail());
            System.out.println("Password (raw): " + loginRequest.getPassword());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            System.out.println("Authentication successful for email: " + loginRequest.getEmail());
            String jwt = jwtUtil.generateToken(authentication.getName());

            // Return JSON object with token
            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            response.put("message", "Login successful");

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e){
            System.out.println("Authentication for email: " + loginRequest.getEmail());
            return ResponseEntity.status(401).body("Error: Invalid email or password");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("Server error during authentication");
        }

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

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        try{
            String email = request.get("email");
            String newPassword = request.get("newPassword");

            System.out.println("=== REST PASSWORD ===");
            System.out.println("Email: " + email);
            System.out.println("New password: " + newPassword);

            // Search the user
            var user = userRepository.findByEmail(email);
            if(user == null){
                return ResponseEntity.status(404).body("User not found");
            }

            // Encript the new pw

            String encodePassword = pwEncoder.encode(newPassword);
            System.out.println("Generated Hash: " + encodePassword);

            // Update user

            user.setPassword(encodePassword);
            userRepository.save(user);

            System.out.println("Password updated for: " + email);

            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error resetting password");
        }
    }
}
