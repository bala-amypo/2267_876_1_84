package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByVin(String vin);

    Optional<Vehicle> findByVin(String vin);

    List<Vehicle> findByOwnerId(Long ownerId);
}
