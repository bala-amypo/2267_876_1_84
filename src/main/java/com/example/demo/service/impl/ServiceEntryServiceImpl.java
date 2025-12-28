package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

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

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        // 🚨 VEHICLE CHECK
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        if (vehicle.getActive() == null || !vehicle.getActive()) {
            throw new IllegalArgumentException("Vehicle is inactive");
        }

        // 🚨 GARAGE CHECK
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        if (garage.getActive() == null || !garage.getActive()) {
            throw new IllegalArgumentException("Garage is inactive");
        }

        // 🚨 FUTURE DATE CHECK
        if (entry.getServiceDate() == null ||
                entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future service date not allowed");
        }

        // 🚨 ODOMETER CHECK
        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException("Odometer reading invalid");
                    }
                });

        // ✅ SET MANAGED ENTITIES
        entry.setVehicle(vehicle);
        entry.setGarage(garage);
        entry.setRecordedAt(LocalDateTime.now());

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getEntriesByGarage(Long garageId) {
        return serviceEntryRepository.findByGarageId(garageId);
    }
}
