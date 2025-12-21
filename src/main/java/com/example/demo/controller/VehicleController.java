package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
    }

    // GET VEHICLE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // GET VEHICLES BY OWNER
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByOwner(
            @PathVariable Long ownerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
    }

    // DEACTIVATE VEHICLE
    @PostMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
        return ResponseEntity.ok().build();
    }
}
