package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    // POST – Create garage
    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return service.createGarage(garage);
    }

    // PUT – Update garage
    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return service.updateGarage(id, garage);
    }

    // GET – Garage by ID
    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return service.getGarageById(id);
    }

    // GET – All garages
    @GetMapping
    public List<Garage> getAll() {
        return service.getAllGarages();
    }

    // PUT – Deactivate garage
    @PutMapping("/{id}/deactivate")
    public Garage deactivate(@PathVariable Long id) {
        return service.deactivateGarage(id);
    }
}
