package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CREATE VEHICLE
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {

        // SERVER ENFORCEMENT (CRITICAL)
        vehicle.setId(null);
        vehicle.setActive(true);
        vehicle.setCreatedAt(null);

        if (vehicle.getVin() == null || vehicle.getVin().isBlank()) {
            throw new IllegalArgumentException("vin is required");
        }
        if (vehicle.getOwnerId() == null) {
            throw new IllegalArgumentException("ownerId is required");
        }
        if (vehicle.getYear() == null || vehicle.getYear() <= 0) {
            throw new IllegalArgumentException("year must be greater than 0");
        }

        return vehicleService.createVehicle(vehicle);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // GET BY VIN
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    // GET BY OWNER
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // DEACTIVATE VEHICLE
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
