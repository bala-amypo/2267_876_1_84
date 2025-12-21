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

    // POST /vehicles – Register vehicle
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // GET /vehicles/{id} – Get vehicle by ID
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // ✅ GET /vehicles/vin/{vin} – Get vehicle by VIN
    @GetMapping("/vin/{vin}")
    public Vehicle getVehicleByVin(@PathVariable String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    // GET /vehicles/owner/{ownerId} – Get vehicles by owner
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // PUT /vehicles/{id}/deactivate – Deactivate vehicle
    @PutMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
