package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    @Query("select s from ServiceEntry s where s.garage.id = :garageId and s.odometerReading > :min")
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, Integer min);

    @Query("select s from ServiceEntry s where s.vehicle.id = :vid and s.serviceDate between :f and :t")
    List<ServiceEntry> findByVehicleAndDateRange(Long vid, LocalDate f, LocalDate t);
}
