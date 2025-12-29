package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtTokenProvider {


    public String generateToken(String email, String role, Long userId) {
      
        return "";
    }

    public boolean validateToken(String token) {
       
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
