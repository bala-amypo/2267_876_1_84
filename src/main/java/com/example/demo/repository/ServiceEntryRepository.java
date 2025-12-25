package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository
        extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByVehicleIdAndServiceDateBetween(
            Long vehicleId,
            LocalDate from,
            LocalDate to
    );

    List<ServiceEntry> findByGarageIdAndOdometerReadingGreaterThanEqual(
            Long garageId,
            int odometer
    );
}
