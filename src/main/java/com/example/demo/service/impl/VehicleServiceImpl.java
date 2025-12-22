package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle createVehicle(Vehicle v) {
        repository.findByVin(v.getVin()).ifPresent(x -> {
            throw new IllegalArgumentException("VIN already exists");
        });
        return repository.save(v);
    }

    public Vehicle getVehicleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public Vehicle getVehicleByVin(String vin) {
        return repository.findByVin(vin)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        repository.save(v);
    }
}
