package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

public class VerificationLogServiceImpl {

    private final VerificationLogRepository logRepo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository l, ServiceEntryRepository e) {
        this.logRepo = l;
        this.entryRepo = e;
    }

    public VerificationLog createLog(VerificationLog log) {
        entryRepo.findById(log.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        log.setVerifiedAt(LocalDateTime.now());
        return logRepo.save(log);
    }
}
