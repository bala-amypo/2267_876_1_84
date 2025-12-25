package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public Map<String, String> register() {
        return Map.of("status", "registered");
    }

    @PostMapping("/login")
    public Map<String, String> login() {
        return Map.of("token", "dummy-token");
    }
}
