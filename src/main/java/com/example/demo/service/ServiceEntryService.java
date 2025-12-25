package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    ServiceEntry getById(Long id);

    // REQUIRED by controller + tests
    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    // REQUIRED by controller + tests
    List<ServiceEntry> getVehicleHistory(
            Long vehicleId,
            LocalDate from,
            LocalDate to
    );

    List<ServiceEntry> findByGarageAndMinOdometer(
            Long garageId,
            int minOdometer
    );
}
