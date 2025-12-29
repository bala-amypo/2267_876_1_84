package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    // ADMIN: Create garage
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Garage create(@RequestBody Garage garage) {
        return service.createGarage(garage);
    }

    // ADMIN: Update garage
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return service.updateGarage(id, garage);
    }

    // ADMIN: View all garages
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Garage> getAll() {
        return service.getAllGarages();
    }

    // ADMIN: Deactivate garage
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateGarage(id);
    }
}
