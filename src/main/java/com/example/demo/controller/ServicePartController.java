package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {
    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ResponseEntity<ServicePart> createServicePart(@Valid @RequestBody ServicePart part) {
        return ResponseEntity.ok(servicePartService.createPart(part));
    }

    @GetMapping("/service/{serviceEntryId}")
    public ResponseEntity<List<ServicePart>> getPartsForService(@PathVariable Long serviceEntryId) {
        return ResponseEntity.ok(servicePartService.getPartsForService(serviceEntryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicePart> getPartById(@PathVariable Long id) {
        return servicePartService.getPartById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ServicePart>> getAllParts() {
        return ResponseEntity.ok(servicePartService.getPartsForService(null));
    }
}
