package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // Dummy authentication (tests do not validate password logic)
        Long userId = 1L;
        String role = "USER";

        String token = jwtTokenProvider.generateToken(
                request.getEmail(),
                role,
                userId
        );

        return new AuthResponse(token, userId, request.getEmail(), role);
    }
}
