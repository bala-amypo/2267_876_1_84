package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;

public class VerificationLogServiceImpl {

    private final VerificationLogRepository repo;

    public VerificationLogServiceImpl(VerificationLogRepository repo) {
        this.repo = repo;
    }

    public VerificationLog createLog(VerificationLog log) {
        return repo.save(log);
    }
}
