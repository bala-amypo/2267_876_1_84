package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
@Tag(name = "Service Part")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    // ADMIN – Add part
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.createPart(part);
    }

    // USER / ADMIN – Get part
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return service.getPartById(id);
    }

    // USER / ADMIN – List parts for entry
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getByEntry(@PathVariable Long entryId) {
        return service.getPartsForEntry(entryId);
    }
}
