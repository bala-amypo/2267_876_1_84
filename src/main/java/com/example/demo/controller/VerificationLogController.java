package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.impl.VerificationLogServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification-logs")
@Tag(name = "Verification Log")
public class VerificationLogController {

    private final VerificationLogServiceImpl verificationLogService;

    public VerificationLogController(VerificationLogServiceImpl verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    // POST – Create verification log
    @PostMapping
    public VerificationLog createLog(@RequestBody VerificationLog log) {
        return verificationLogService.createLog(log);
    }

    // GET – Log by ID
    @GetMapping("/{id}")
    public VerificationLog getById(@PathVariable Long id) {
        return verificationLogService.getLogById(id);
    }
}
