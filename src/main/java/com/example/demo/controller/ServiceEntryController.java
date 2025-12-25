package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private static final Map<Long, ServiceEntry> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        long id = idGen.getAndIncrement();
        entry.setId(id);
        entry.setRecordedAt(LocalDateTime.now());
        store.put(id, entry);
        return entry;
    }

    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return store.get(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        return new ArrayList<>(store.values());
    }
}
