package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository s,
                                   VehicleRepository v,
                                   GarageRepository g) {
        this.serviceEntryRepository = s;
        this.vehicleRepository = v;
        this.garageRepository = g;
    }

    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle v = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!Boolean.TRUE.equals(v.getActive())) {
            throw new IllegalArgumentException("active vehicles");
        }

        Garage g = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException(">=");
                    }
                });

        return serviceEntryRepository.save(entry);
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
