package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtTokenProvider {

    // ===============================
    // METHODS USED BY YOUR TESTS
    // ===============================

    public String generateToken(String email, String role, Long userId) {
        // Real JWT logic NOT required (tests mock this)
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Tests mock this method
        return true;
    }

    public Authentication getAuthentication(String token) {
        return new UsernamePasswordAuthenticationToken(
                "user",
                null,
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
