package com.example.auth_service.auth.controller;

import com.example.auth_service.auth.dto.AuthResponse;
import com.example.auth_service.auth.dto.LoginRequest;
import com.example.auth_service.auth.dto.RegisterRequest;
import com.example.auth_service.auth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        authService.register(request.getEmail(), request.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        String response = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(response));
    }
}
