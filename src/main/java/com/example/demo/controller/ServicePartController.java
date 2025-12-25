package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ResponseEntity<ServicePart> create(@RequestBody ServicePart part) {
        return ResponseEntity.ok(servicePartService.createPart(part));
    }

    @GetMapping("/entry/{entryId}")
    public ResponseEntity<List<ServicePart>> getByEntry(@PathVariable Long entryId) {
        return ResponseEntity.ok(servicePartService.getPartsForServiceEntry(entryId));
    }
}
