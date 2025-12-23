package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // Used by service logic
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    // Used by tests
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // ✅ FIXED: Explicit JPQL (NO derived query)
    @Query("""
           SELECT s
           FROM ServiceEntry s
           WHERE s.garage.id = :garageId
             AND s.odometerReading > :minOdometer
           """)
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") Long garageId,
            @Param("minOdometer") Integer minOdometer
    );

    // Used by HQL tests
    @Query("""
           SELECT s
           FROM ServiceEntry s
           WHERE s.vehicle.id = :vehicleId
             AND s.serviceDate BETWEEN :from AND :to
           """)
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") Long vehicleId,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );
}
