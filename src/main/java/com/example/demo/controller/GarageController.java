package com.example.demo.controller;

import com.example.demo.model.Garage;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private static final Map<Long, Garage> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        long id = idGen.getAndIncrement();
        garage.setId(id);
        garage.setActive(true);
        store.put(id, garage);
        return garage;
    }

    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return store.get(id);
    }

    @GetMapping
    public List<Garage> getAll() {
        return new ArrayList<>(store.values());
    }

    @PutMapping("/{id}/deactivate")
    public Garage deactivate(@PathVariable Long id) {
        Garage g = store.get(id);
        if (g != null) g.setActive(false);
        return g;
    }
}
