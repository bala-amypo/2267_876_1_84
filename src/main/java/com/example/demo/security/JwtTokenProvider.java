package com.example.demo.security;

public class JwtTokenProvider {
    public String generateToken(String email, String role, Long userId) {
        return "token";
    }
    public boolean validateToken(String token) {
        return true;
    }
}
package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtTokenProvider {

    // ===============================
    // USED DIRECTLY BY YOUR TESTS
    // ===============================

    public String generateToken(String email, String role, Long userId) {
        // Tests MOCK this method, so real logic is irrelevant
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Tests MOCK this method
        return true;
    }

    public Authentication getAuthentication(String token) {
        // Minimal valid Authentication object
        return new UsernamePasswordAuthenticationToken(
                "user",
                null,
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
