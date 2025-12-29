package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
@Tag(name = "Service Entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return service.createServiceEntry(entry);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getServiceEntryById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    @Transactional(readOnly = true)
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    
    @GetMapping("/garage/{garageId}")
    @Transactional(readOnly = true)
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return service.getEntriesByGarage(garageId);
    }
}
