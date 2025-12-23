package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;   // ✅ INTERFACE ONLY

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // ---------------- CREATE VEHICLE ----------------
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // ---------------- GET VEHICLE BY ID ----------------
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // ---------------- GET VEHICLES BY OWNER ----------------
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // ---------------- DEACTIVATE VEHICLE (IMPORTANT) ----------------
    // ✅ MUST BE PUT (as per image & REST semantics)
    @PutMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
