package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    // POST /api/service-parts
    @PostMapping
    public ServicePart addPart(@RequestBody ServicePart part) {
        return servicePartService.addPart(part);
    }

    // GET /api/service-parts/{id}
    @GetMapping("/{id}")
    public ServicePart getPartById(@PathVariable Long id) {
        return servicePartService.getPartById(id);
    }

    // GET /api/service-parts/entry/{entryId}
    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getPartsByEntry(@PathVariable Long entryId) {
        return servicePartService.getPartsByEntry(entryId);
    }
}
