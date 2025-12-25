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
        entry.setRecordedAt(LocalDateTime.now());
        long id = idGen.getAndIncrement();
        store.put(id, entry);
        return entry;
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getByVehicle(@PathVariable Long vehicleId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            if (vehicleId.equals(e.getVehicleId())) {
                list.add(e);
            }
        }
        return list;
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(@PathVariable Long garageId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            if (garageId.equals(e.getGarageId())) {
                list.add(e);
            }
        }
        return list;
    }
}
