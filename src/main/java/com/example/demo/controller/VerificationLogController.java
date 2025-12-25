package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private static final Map<Long, VerificationLog> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        long id = idGen.getAndIncrement();
        log.setId(id);
        log.setVerifiedAt(LocalDateTime.now());
        store.put(id, log);
        return log;
    }

    @GetMapping("/{id}")
    public VerificationLog getById(@PathVariable Long id) {
        return store.get(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<VerificationLog> getByEntry(@PathVariable Long entryId) {
        return new ArrayList<>(store.values());
    }
}
