package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByVehicleAndServiceDateBetween(
            Vehicle vehicle, LocalDate start, LocalDate end);

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByGarageId(Long garageId);

    List<ServiceEntry> findByGarageIdAndOdometerReadingGreaterThan(
            Long garageId, int minOdometer);
}
