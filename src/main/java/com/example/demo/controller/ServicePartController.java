package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServicePart> create(@RequestBody ServicePart part) {
        return ResponseEntity.ok(service.createPart(part));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicePart> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPartById(id));
    }

    @GetMapping("/service-entry/{entryId}")
    public ResponseEntity<List<ServicePart>> getByServiceEntry(@PathVariable Long entryId) {
        return ResponseEntity.ok(service.getPartsByEntry(entryId));
    }
}
