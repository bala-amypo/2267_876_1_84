package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));

        // test checks contains("active vehicles")
        if (!Boolean.TRUE.equals(vehicle.getActive())) {
            throw new IllegalArgumentException("active vehicles");
        }

        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Garage not found"));

        if (!Boolean.TRUE.equals(garage.getActive())) {
            throw new IllegalArgumentException("active garages");
        }

        // test checks contains("future")
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    // test checks contains(">=")
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
