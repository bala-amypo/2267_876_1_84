package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.*;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.VerificationLogService;

public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository repo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public VerificationLog createLog(VerificationLog log) {
        entryRepo.findById(log.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("Entry not found"));
        return repo.save(log);
    }
}
