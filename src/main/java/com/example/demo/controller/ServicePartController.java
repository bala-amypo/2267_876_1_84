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

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.create(part);
    }

    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/service-entry/{serviceEntryId}")
    public List<ServicePart> getByServiceEntry(@PathVariable Long serviceEntryId) {
        return service.getByServiceEntry(serviceEntryId);
    }
}
