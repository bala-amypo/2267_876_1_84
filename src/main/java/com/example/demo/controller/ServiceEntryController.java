package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryRepository repo;

    public ServiceEntryController(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return repo.save(entry);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // GET BY VEHICLE
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }

    // GET BY GARAGE
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return repo.findByGarageId(garageId);
    }
}
