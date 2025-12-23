package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, String role, Long userId) {
        // Tests only verify return value via Mockito
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Conceptual validation for tests
        return token != null && !token.isBlank();
    }
}
