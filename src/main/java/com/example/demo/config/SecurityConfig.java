package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm ->
                sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth

                // 🔓 AUTH
                .requestMatchers("/api/auth/**").permitAll()

                // 👤 USER ACCESS
                .requestMatchers("/api/vehicles/**").hasRole("USER")
                .requestMatchers("/api/service-entries/**").hasAnyRole("USER", "ADMIN")

                // 🛠️ ADMIN / GARAGE ACCESS
                .requestMatchers("/api/garages/**").hasRole("ADMIN")
                .requestMatchers("/api/service-parts/**").hasRole("ADMIN")
                .requestMatchers("/api/verification-logs/**").hasRole("ADMIN")

                // ❌ EVERYTHING ELSE
                .anyRequest().authenticated()
            )

            // JWT FILTER (already in your project)
            .addFilterBefore(
                jwtAuthenticationFilter(),
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}
