package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public Garage create(@RequestBody Garage garage) {

        // SERVER-CONTROLLED FIELDS
        garage.setId(null);
        garage.setActive(true);

        if (garage.getGarageName() == null || garage.getGarageName().isBlank()) {
            throw new IllegalArgumentException("garageName is required");
        }

        return garageService.createGarage(garage);
    }

    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @GetMapping
    public List<Garage> getAll() {
        return garageService.getAllGarages();
    }

    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return garageService.updateGarage(id, garage);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        garageService.deactivateGarage(id);
    }
}
