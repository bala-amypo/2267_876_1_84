package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;   // ✅ interface

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }

    @GetMapping("/{id}")
    public Garage getById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PostMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        garageService.deactivateGarage(id);
    }
}
