package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.impl.VehicleServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle")
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    // POST – Register vehicle
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // GET – Vehicle by ID
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // GET – Vehicle by VIN
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    // GET – Vehicles by Owner
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    // PUT – Deactivate vehicle
    @PutMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
