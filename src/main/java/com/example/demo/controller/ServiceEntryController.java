package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // ADMIN: Add service entry
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return service.createServiceEntry(entry);
    }

    // USER + ADMIN: View service history of vehicle
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    // USER + ADMIN: View single service entry
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getServiceEntryById(id);
    }
}
