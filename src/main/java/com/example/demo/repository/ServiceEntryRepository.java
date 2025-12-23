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

    // REQUIRED by tests (exact name)
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    // REQUIRED by tests
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // REQUIRED by HQL tests (mocked, body not executed)
    @Query("select s from ServiceEntry s where s.garage.id = :garageId and s.odometerReading > :minOdometer")
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") Long garageId,
            @Param("minOdometer") Integer minOdometer
    );

    // REQUIRED by HQL tests (mocked, body not executed)
    @Query("select s from ServiceEntry s where s.vehicle.id = :vehicleId and s.serviceDate between :from and :to")
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") Long vehicleId,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );
}
