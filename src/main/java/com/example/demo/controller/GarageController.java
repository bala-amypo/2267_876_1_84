package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.impl.GarageServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage")
public class GarageController {

    private final GarageServiceImpl garageService;

    public GarageController(GarageServiceImpl garageService) {
        this.garageService = garageService;
    }

    // POST – Create garage
    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }

    // GET – Garage by ID
    @GetMapping("/{id}")
    public Garage getGarage(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    // PUT – Deactivate garage
    @PutMapping("/{id}/deactivate")
    public void deactivateGarage(@PathVariable Long id) {
        garageService.deactivateGarage(id);
    }
}
