package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByGarageId(Long garageId);

    // 🔴 REQUIRED BY TEST CASE
    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.garage.id = :garageId
        AND s.odometerReading >= :minOdometer
    """)
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer);

    // 🔴 REQUIRED BY TEST CASE
    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.vehicle.id = :vehicleId
        AND s.serviceDate BETWEEN :startDate AND :endDate
    """)
    List<ServiceEntry> findByVehicleAndDateRange(
            Long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );
}
