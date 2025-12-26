package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // used by tests (conceptual only)
    default List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer) {
        return List.of();
    }

    default List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, LocalDate from, LocalDate to) {
        return List.of();
    }
}
