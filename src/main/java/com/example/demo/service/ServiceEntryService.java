package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    ServiceEntry getById(Long id);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    List<ServiceEntry> getVehicleHistory(Long vehicleId, LocalDate from, LocalDate to);
}
