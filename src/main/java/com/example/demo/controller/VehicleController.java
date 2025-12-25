package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Map<Long, Vehicle> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    // CREATE
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        long id = idGen.getAndIncrement();

        try {
            var idField = Vehicle.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(vehicle, id);

            var createdAtField = Vehicle.class.getDeclaredField("createdAt");
            createdAtField.setAccessible(true);
            createdAtField.set(vehicle, LocalDateTime.now());
        } catch (Exception ignored) {}

        vehicle.setActive(true);
        store.put(id, vehicle);
        return vehicle;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return store.get(id); // null if not found
    }

    // GET BY VIN
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        for (Vehicle v : store.values()) {
            if (vin.equals(v.getVin())) {
                return v;
            }
        }
        return null;
    }

    // GET BY OWNER
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle v : store.values()) {
            if (ownerId.equals(v.getOwnerId())) {
                list.add(v);
            }
        }
        return list;
    }

    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public Vehicle deactivate(@PathVariable Long id) {
        Vehicle v = store.get(id);
        if (v != null) {
            v.setActive(false);
        }
        return v;
    }
}
