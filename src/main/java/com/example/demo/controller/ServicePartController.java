package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private static final Map<Long, ServicePart> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        long id = idGen.getAndIncrement();
        part.setId(id);
        store.put(id, part);
        return part;
    }

    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return store.get(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getByEntry(@PathVariable Long entryId) {
        return new ArrayList<>(store.values());
    }
}
