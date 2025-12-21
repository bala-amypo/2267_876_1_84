package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl {

    @Autowired
    private VerificationLogRepository verificationLogRepository;

    @Autowired
    private ServiceEntryRepository serviceEntryRepository;

    public VerificationLog createLog(VerificationLog log) {

        ServiceEntry entry = serviceEntryRepository
                .findById(log.getServiceEntry().getId())
                .orElseThrow();

        log.setVerifiedAt(LocalDateTime.now());
        return verificationLogRepository.save(log);
    }
}
