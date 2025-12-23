package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, String role, Long userId) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return !"invalid-token".equals(token);
    }
}
