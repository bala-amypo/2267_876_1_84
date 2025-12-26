package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.List;

public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository repo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository r,
                                   VehicleRepository v,
                                   GarageRepository g) {
        this.repo = r;
        this.vehicleRepo = v;
        this.garageRepo = g;
    }

    public ServiceEntry createServiceEntry(ServiceEntry e) {

        Vehicle v = vehicleRepo.findById(e.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!Boolean.TRUE.equals(v.getActive()))
            throw new IllegalArgumentException("active vehicles");

        if (e.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("future");

        repo.findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (e.getOdometerReading() < last.getOdometerReading())
                        throw new IllegalArgumentException(">=");
                });

        return repo.save(e);
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }
}
