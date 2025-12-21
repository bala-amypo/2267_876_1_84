package com.example.demo.service;

import com.example.demo.model.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle create(Vehicle vehicle);

    Vehicle getById(Long id);

    List<Vehicle> getByOwner(Long ownerId);

    Vehicle update(Long id, Vehicle vehicle);

    void deactivate(Long id);
}
