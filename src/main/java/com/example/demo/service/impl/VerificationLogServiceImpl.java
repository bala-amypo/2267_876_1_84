package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private static final Map<Long, VerificationLog> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @Override
    public VerificationLog create(VerificationLog log) {
        long id = idGen.getAndIncrement();
        log.setId(id);
        log.setVerifiedAt(LocalDateTime.now());
        store.put(id, log);
        return log;
    }

    @Override
    public VerificationLog getById(Long id) {
        return store.get(id);
    }

    @Override
    public List<VerificationLog> getByServiceEntry(Long serviceEntryId) {
        List<VerificationLog> list = new ArrayList<>();
        for (VerificationLog v : store.values()) {
            if (serviceEntryId.equals(v.getServiceEntryId())) {
                list.add(v);
            }
        }
        return list;
    }
}
