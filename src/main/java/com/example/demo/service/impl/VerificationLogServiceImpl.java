package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository repo;

    public VerificationLogServiceImpl(VerificationLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public VerificationLog create(VerificationLog log) {
        return repo.save(log);
    }

    @Override
    public VerificationLog getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<VerificationLog> getByServiceEntry(Long serviceEntryId) {
        return repo.findByServiceEntryId(serviceEntryId);
    }
}
