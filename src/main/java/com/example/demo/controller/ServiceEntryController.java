package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
        return service.create(entry);
    }

    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return service.getByVehicle(vehicleId);
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return service.getByGarage(garageId);
    }
}
