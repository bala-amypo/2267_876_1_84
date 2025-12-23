package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.impl.VehicleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    // POST /vehicles
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // GET /vehicles/{id}
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // GET /vehicles/owner/{ownerId}
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // POST /vehicles/{id}/deactivate
    @PostMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
