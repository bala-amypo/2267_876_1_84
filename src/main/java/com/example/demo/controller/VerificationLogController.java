package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return service.create(log);
    }

    @GetMapping("/{id}")
    public VerificationLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/service-entry/{serviceEntryId}")
    public List<VerificationLog> getByServiceEntry(
            @PathVariable Long serviceEntryId) {
        return service.getByServiceEntry(serviceEntryId);
    }
}
