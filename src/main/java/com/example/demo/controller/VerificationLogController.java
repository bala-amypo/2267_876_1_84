package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification-logs")
@Tag(name = "Verification Logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    // ADMIN – Create log
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return service.createLog(log);
    }

    // USER / ADMIN – Get log by ID
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public VerificationLog getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    // USER / ADMIN – Logs for entry
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/entry/{entryId}")
    public List<VerificationLog> getByEntry(@PathVariable Long entryId) {
        return service.getLogsForEntry(entryId);
    }
}
