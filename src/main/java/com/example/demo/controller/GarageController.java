package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.impl.GarageServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage Controller")
public class GarageController {

    private final GarageServiceImpl garageService;

    public GarageController(GarageServiceImpl garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }

    @GetMapping("/{id}")
    public Garage get(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        garageService.deactivateGarage(id
