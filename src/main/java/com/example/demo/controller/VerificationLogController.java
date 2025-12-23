package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.impl.VerificationLogServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private final VerificationLogServiceImpl verificationLogService;

    public VerificationLogController(VerificationLogServiceImpl verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    // POST /verification-logs
    @PostMapping
    public VerificationLog createLog(@RequestBody VerificationLog log) {
        return verificationLogService.createLog(log);
    }
}
