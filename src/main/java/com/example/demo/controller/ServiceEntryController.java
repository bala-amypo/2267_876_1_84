package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.impl.ServiceEntryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryServiceImpl serviceEntryService;

    public ServiceEntryController(ServiceEntryServiceImpl serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // POST /service-entries
    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    // GET /service-entries/vehicle/{vehicleId}
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesForVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesForVehicle(vehicleId);
    }
}
