package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // POST /api/service-entries
    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    // GET /api/service-entries/{id}
    @GetMapping("/{id}")
    public ServiceEntry getEntryById(@PathVariable Long id) {
        return serviceEntryService.getEntryById(id);
    }

    // GET /api/service-entries/vehicle/{vehicleId}
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesByVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesByVehicle(vehicleId);
    }

    // GET /api/service-entries/garage/{garageId}
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getEntriesByGarage(@PathVariable Long garageId) {
        return serviceEntryService.getEntriesByGarage(garageId);
    }
}
