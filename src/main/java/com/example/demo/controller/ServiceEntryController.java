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

    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return serviceEntryService.createServiceEntry(entry);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesForVehicle(vehicleId);
    }
}
