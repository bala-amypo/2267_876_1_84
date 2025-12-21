package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    // POST – Add service part
    @PostMapping
    public ServicePart add(@RequestBody ServicePart part) {
        return service.addPart(part);
    }

    // GET – Part by ID
    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return service.getPartById(id);
    }

    // GET – Parts by service entry
    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getByEntry(@PathVariable Long entryId) {
        return service.getPartsByEntry(entryId);
    }
}
