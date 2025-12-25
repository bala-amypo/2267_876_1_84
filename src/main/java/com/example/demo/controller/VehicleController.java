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
