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

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.createPart(part);
    }
art
    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return service.getPartById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getByEntry(@PathVariable Long entryId) {
        return service.getPartsForEntry(entryId);
    }
}
