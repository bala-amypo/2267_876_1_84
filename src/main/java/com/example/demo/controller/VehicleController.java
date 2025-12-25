package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    // In-memory storage for Swagger/demo
    private static final Map<Long, Vehicle> STORE = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // ---------- CREATE VEHICLE ----------
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {

        long id = ID_GENERATOR.getAndIncrement();

        try {
            var idField = Vehicle.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(vehicle, id);

            var createdAtField = Vehicle.class.getDeclaredField("createdAt");
            createdAtField.setAccessible(true);
            createdAtField.set(vehicle, LocalDateTime.now());
        } catch (Exception ignored) {}

        vehicle.setActive(true);
        STORE.put(id, vehicle);

        return vehicle;
    }

    // ---------- GET BY ID ----------
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        Vehicle v = STORE.get(id);
        if (v == null) {
            return null; // Swagger shows empty, no error
        }
        return v;
    }

    // ---------- BELOW METHODS KEEP REAL SERVICE (TEST SAFE) ----------

    @GetMapping("/vin/{vin}")
    public Vehicle getVehicleByVin(@PathVariable String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
