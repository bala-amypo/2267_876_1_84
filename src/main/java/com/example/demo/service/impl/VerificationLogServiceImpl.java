package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;

public class VerificationLogServiceImpl {

    private final VerificationLogRepository repo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public VerificationLog createLog(VerificationLog log) {
        entryRepo.findById(log.getServiceEntry().getId())
                .orElseThrow(EntityNotFoundException::new);

        log.setVerifiedAt(LocalDateTime.now());
        return repo.save(log);
    }
}
