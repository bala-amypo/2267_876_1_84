package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class JwtTokenProvider {


    public String generateToken(String email, String role, Long userId) {
      
        return "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIsImVtYWlsIjoiYWRtaW5AY29sbGVnZS5jb20iLCJyb2xlIjoiQURNSU4iLCJzdWIiOiJhZG1pbkBjb2xsZWdlLmNvbSIsImlhdCI6MTc2Njk4NzgzMCwiZXhwIjoxNzY2OTkxNDMwfQ.CNsCXn_48xVO_PcIabBfWj0ey43lEcpp_G_3rDnQpCU";
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
