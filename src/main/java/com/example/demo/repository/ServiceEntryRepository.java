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

    @Query("select s from ServiceEntry s where s.garage.id = :garageId and s.odometerReading > :minOdometer")
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, Integer minOdometer);

    @Query("select s from ServiceEntry s where s.vehicle.id = :vehicleId and s.serviceDate between :from and :to")
    List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, LocalDate from, LocalDate to);
}
