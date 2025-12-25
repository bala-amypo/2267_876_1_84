package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Garage;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private static final Map<Long, ServiceEntry> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    // CREATE SERVICE ENTRY
    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        long id = idGen.getAndIncrement();

        try {
            var idField = ServiceEntry.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entry, id);

            var recordedAtField = ServiceEntry.class.getDeclaredField("recordedAt");
            recordedAtField.setAccessible(true);
            recordedAtField.set(entry, LocalDateTime.now());
        } catch (Exception ignored) {}

        store.put(id, entry);
        return entry;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return store.get(id); // null if not found
    }

    // GET BY VEHICLE ID
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            Vehicle v = e.getVehicle();
            if (v != null && vehicleId.equals(v.getId())) {
                list.add(e);
            }
        }
        return list;
    }

    // GET BY GARAGE ID
    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            Garage g = e.getGarage();
            if (g != null && garageId.equals(g.getId())) {
                list.add(e);
            }
        }
        return list;
    }
}
