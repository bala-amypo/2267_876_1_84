package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository repo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo,
                                   VehicleRepository vehicleRepo,
                                   GarageRepository garageRepo) {
        this.repo = repo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        Vehicle v = vehicleRepo.findById(entry.getVehicle().getId()).orElseThrow();

        if (!v.getActive())
            throw new IllegalArgumentException("Only active vehicles allowed");

        if (entry.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("future date");

        repo.findTopByVehicleOrderByOdometerReadingDesc(v)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading())
                        throw new IllegalArgumentException(">= last odometer");
                });

        return repo.save(entry);
    }

    public List<ServiceEntry> getEntriesForVehicle(long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }
}
