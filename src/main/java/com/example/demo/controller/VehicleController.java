package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // USER: Register vehicle
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.createVehicle(vehicle);
    }

    // USER: Get vehicle by ID
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    // USER: Get vehicles by owner
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    // USER: Deactivate own vehicle
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
    }
}
