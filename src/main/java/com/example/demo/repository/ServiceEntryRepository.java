package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    @Query("SELECT se FROM ServiceEntry se WHERE se.vehicle.id = :vehicleId")
    List<ServiceEntry> findByVehicleId(@Param("vehicleId") Long vehicleId);
    
    @Query("SELECT se FROM ServiceEntry se WHERE se.id = :id AND se.vehicle.id = :vehicleId")
    Optional<ServiceEntry> findByIdAndVehicleId(@Param("id") Long id, @Param("vehicleId") Long vehicleId);
    
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
    
    List<ServiceEntry> findByServiceDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT s FROM ServiceEntry s WHERE s.garage.id = :garageId AND s.odometerReading > :minOdometer")
    List<ServiceEntry> findByGarageAndMinOdometer(@Param("garageId") Long garageId, @Param("minOdometer") Integer minOdometer);
    
    @Query("SELECT s FROM ServiceEntry s WHERE s.vehicle.id = :vehicleId AND s.serviceDate BETWEEN :fromDate AND :toDate")
    List<ServiceEntry> findByVehicleAndDateRange(@Param("vehicleId") Long vehicleId, @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
