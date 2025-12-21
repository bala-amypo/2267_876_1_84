package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification-logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    // POST – Create verification log
    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return service.createLog(log);
    }

    // GET – Log by ID
    @GetMapping("/{id}")
    public VerificationLog getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    // GET – Logs by service entry
    @GetMapping("/entry/{entryId}")
    public List<VerificationLog> getByEntry(@PathVariable Long entryId) {
        return service.getLogsByEntry(entryId);
    }
}
