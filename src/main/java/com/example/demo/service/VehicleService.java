package com.example.demo.service;

import com.example.demo.model.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle registerVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);          // ✅ ADD THIS

    Vehicle getVehicleByVin(String vin);

    List<Vehicle> getVehiclesByOwner(Long ownerId);

    Vehicle deactivateVehicle(Long vehicleId); // ✅ CHANGE return type
}
