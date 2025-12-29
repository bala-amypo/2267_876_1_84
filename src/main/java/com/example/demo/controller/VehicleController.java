package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.createVehicle(vehicle);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/vin/{vin}")
    public Vehicle getByVin(@PathVariable String vin) {
        return service.getVehicleByVin(vin);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
    }
}
