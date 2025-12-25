package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/service-entries")
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
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> byVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    @GetMapping("/vehicle/{vehicleId}/history")
    public List<ServiceEntry> history(
            @PathVariable Long vehicleId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return service.getVehicleHistory(vehicleId, from, to);
    }
}
