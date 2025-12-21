package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // POST /api/vehicles
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
    }

    // GET /api/vehicles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // GET /api/vehicles/vin/{vin}
    @GetMapping("/vin/{vin}")
    public ResponseEntity<Vehicle> getVehicleByVin(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getVehicleByVin(vin));
    }

    // GET /api/vehicles/owner/{ownerId}
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByOwner(
            @PathVariable Long ownerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
    }

    // PUT /api/vehicles/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
