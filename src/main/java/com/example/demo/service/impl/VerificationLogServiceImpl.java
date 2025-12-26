package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository verificationLogRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public VerificationLogServiceImpl(
            VerificationLogRepository verificationLogRepository,
            ServiceEntryRepository serviceEntryRepository
    ) {
        this.verificationLogRepository = verificationLogRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {
        serviceEntryRepository.findById(log.getServiceEntry().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("ServiceEntry not found"));
        return verificationLogRepository.save(log);
    }

    @Override
    public VerificationLog getLogById(Long id) {
        return verificationLogRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("VerificationLog not found"));
    }

    @Override
    public List<VerificationLog> getLogsForEntry(Long entryId) {
        return verificationLogRepository.findByServiceEntryId(entryId);
    }
}
