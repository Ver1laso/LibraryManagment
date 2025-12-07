package dev.jlprisan.LibraryManagment.Service;

import dev.jlprisan.LibraryManagment.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .username(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }
}
