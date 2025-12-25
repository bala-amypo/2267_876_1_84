package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // ✅ required by tests
    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByGarageId(Long garageId);

    List<ServiceEntry> findByGarageIdAndOdometerReadingGreaterThanEqual(Long garageId, int min);

    List<ServiceEntry> findByVehicleIdAndServiceDateBetween(
            Long vehicleId, LocalDate start, LocalDate end
    );
}
