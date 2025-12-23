package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.impl.ServiceEntryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
@Tag(name = "Service Entry")
public class ServiceEntryController {

    private final ServiceEntryServiceImpl serviceEntryService;

    public ServiceEntryController(ServiceEntryServiceImpl serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // POST – Create service entry
    @PostMapping
    public ServiceEntry createEntry(@RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    // GET – Entry by ID
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return serviceEntryService.getServiceEntryById(id);
    }

    // GET – Entries for vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesForVehicle(vehicleId);
    }

    // GET – Entries by garage
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return serviceEntryService.getEntriesByGarage(garageId);
    }
}
