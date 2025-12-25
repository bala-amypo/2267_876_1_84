package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, String role, Long userId) {
        // Tests MOCK this method, so implementation can be simple
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Tests MOCK this method
        return true;
    }

    public String getEmailFromToken(String token) {
        return "user@example.com";
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }
}
