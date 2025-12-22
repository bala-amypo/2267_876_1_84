package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setActive(true);
        return repository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return repository.findByVin(vin).orElse(null);
    }

    @Override
    public java.util.List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    @Override
    public Vehicle deactivateVehicle(Long id) {
        Vehicle vehicle = repository.findById(id).orElse(null);
        if (vehicle != null) {
            vehicle.setActive(false);
            return repository.save(vehicle);
        }
        return null;
    }
}
