package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVin(String vin);
    List<Vehicle> findByOwnerId(Long ownerId);
}

public interface GarageRepository extends JpaRepository<Garage, Long> {
    Optional<Garage> findByGarageName(String garageName);
}

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer);
    List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, LocalDate from, LocalDate to);
}

public interface ServicePartRepository extends JpaRepository<ServicePart, Long> {}

public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {}
