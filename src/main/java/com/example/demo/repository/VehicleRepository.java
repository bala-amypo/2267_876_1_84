package com.example.demo.service;

import com.example.demo.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle registerVehicle(Vehicle vehicle);

    Vehicle getVehicleByVin(String vin);

    List<Vehicle> getVehiclesByOwner(Long ownerId);

    void deactivateVehicle(Long vehicleId);
}
