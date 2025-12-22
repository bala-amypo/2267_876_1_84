package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    // ✅ CREATE PART (FIXED)
    @PostMapping("/service-entry/{serviceEntryId}")
    public ServicePart createPart(
            @PathVariable Long serviceEntryId,
            @RequestBody ServicePart part) {

        return service.createPart(serviceEntryId, part);
    }

    // GET PART BY ID
    @GetMapping("/{id}")
    public ServicePart getPartById(@PathVariable Long id) {
        return service.getPartById(id);
    }

    // GET PARTS BY SERVICE ENTRY
    @GetMapping("/service-entry/{serviceEntryId}")
    public List<ServicePart> getPartsByEntry(@PathVariable Long serviceEntryId) {
        return service.getPartsByEntry(serviceEntryId);
    }
}
