package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    // POST – Create service entry
    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return service.createServiceEntry(entry);
    }

    // GET – Entry by ID
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getServiceEntryById(id);
    }

    // GET – Entries by vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesByVehicle(vehicleId);
    }

    // GET – Entries by garage
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return service.getEntriesByGarage(garageId);
    }
}
