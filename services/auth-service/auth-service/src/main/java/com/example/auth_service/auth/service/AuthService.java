package com.example.auth_service.auth.service;

import com.example.auth_service.auth.security.JwtUtil;
import com.example.auth_service.users.Role;
import com.example.auth_service.users.User;
import com.example.auth_service.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public void register(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User(email, passwordEncoder.encode(password), Role.USER);
        userRepository.save(user);
    }

    public String login(String email, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(token);

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
    }
}
