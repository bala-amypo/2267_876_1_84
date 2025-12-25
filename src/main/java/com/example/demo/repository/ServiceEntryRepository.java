package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByGarageId(Long garageId);

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleAndDateRange(
            Long vehicleId,
            LocalDate from,
            LocalDate to
    );
}
