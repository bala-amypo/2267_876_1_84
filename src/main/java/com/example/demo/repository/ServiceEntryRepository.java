package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // Used by tests (conceptual)
    default List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int min) {
        return List.of();
    }

    default List<ServiceEntry> findByVehicleAndDateRange(Long v, LocalDate f, LocalDate t) {
        return List.of();
    }
}
