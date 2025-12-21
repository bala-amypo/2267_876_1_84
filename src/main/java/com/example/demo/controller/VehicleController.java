package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // POST – Register vehicle
    @PostMapping
    public Vehicle register(@RequestBody Vehicle vehicle) {
        return service.registerVehicle(vehicle);
    }

    // GET – Vehicle by ID
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    // GET – Vehicle by VIN
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        return service.getVehicleByVin(vin);
    }

    // GET – Vehicles by Owner
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    // PUT – Deactivate vehicle
    @PutMapping("/{id}/deactivate")
    public Vehicle deactivate(@PathVariable Long id) {
        return service.deactivateVehicle(id);
    }
}
