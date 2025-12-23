package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.impl.GarageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageServiceImpl garageService;

    public GarageController(GarageServiceImpl garageService) {
        this.garageService = garageService;
    }

    // POST /garages
    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }
}
