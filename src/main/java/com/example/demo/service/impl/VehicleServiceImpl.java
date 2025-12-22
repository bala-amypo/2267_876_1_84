package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existing = getVehicleById(id);
        existing.setRegistrationNumber(vehicle.getRegistrationNumber());
        existing.setOwnerName(vehicle.getOwnerName());
        existing.setModel(vehicle.getModel());
        return repository.save(existing);
    }

    @Override
    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}
