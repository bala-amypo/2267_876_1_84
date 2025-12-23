package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    public VerificationLog createLog(VerificationLog log) {
        log.setVerifiedAt(LocalDateTime.now());
        return verificationLogRepository.save(log);
    }

    public VerificationLog getLogById(Long id) {
        return verificationLogRepository.findById(id).orElse(null);
    }
}
