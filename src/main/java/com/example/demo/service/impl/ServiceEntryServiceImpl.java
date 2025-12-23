package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository e, VehicleRepository v, GarageRepository g) {
        this.entryRepo = e;
        this.vehicleRepo = v;
        this.garageRepo = g;
    }

    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle v = vehicleRepo.findById(entry.getVehicle().getId())
                .orElseThrow(EntityNotFoundException::new);

        Garage g = garageRepo.findById(entry.getGarage().getId())
                .orElseThrow(EntityNotFoundException::new);

        if (!v.getActive()) {
            throw new IllegalArgumentException("active vehicles");
        }

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        entryRepo.findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException(">=");
                    }
                });

        entry.setVehicle(v);
        entry.setGarage(g);

        return entryRepo.save(entry);
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return entryRepo.findByVehicleId(vehicleId);
    }
}
