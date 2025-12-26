package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    // 🔴 REQUIRED — AuthController depends on this
    User getByEmail(String email);
}
