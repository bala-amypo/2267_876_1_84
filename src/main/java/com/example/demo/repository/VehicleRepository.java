package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // REQUIRED by tests
    Optional<Vehicle> findByVin(String vin);

    // REQUIRED by tests
    List<Vehicle> findByOwnerId(Long ownerId);
}
