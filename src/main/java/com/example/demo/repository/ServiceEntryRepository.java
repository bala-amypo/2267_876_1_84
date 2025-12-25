package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // ✔ Used by tests
    List<ServiceEntry> findByVehicle(Vehicle vehicle);

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleAndServiceDateBetween(
            Vehicle vehicle,
            LocalDate start,
            LocalDate end
    );

    List<ServiceEntry> findByGarage_IdAndOdometerReadingGreaterThan(
            Long garageId,
            int minOdometer
    );
}
