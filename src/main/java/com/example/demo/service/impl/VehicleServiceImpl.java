package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        if (vehicleRepository.findByVin(vehicle.getVin()).isPresent()) {
            // test checks contains("VIN")
            throw new IllegalArgumentException("VIN already exists");
        }
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));
    }

    public Vehicle getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));
    }

    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        vehicleRepository.save(v);
    }
}
