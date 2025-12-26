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

    // ✅ Constructor Injection (MANDATORY for tests)
    public ServiceEntryServiceImpl(
            ServiceEntryRepository serviceEntryRepository,
            VehicleRepository vehicleRepository,
            GarageRepository garageRepository
    ) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        if (entry.getVehicle() == null || entry.getVehicle().getId() == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        if (entry.getGarage() == null || entry.getGarage().getId() == null) {
            throw new IllegalArgumentException("Garage not found");
        }

        // 🔹 LOAD MANAGED VEHICLE
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!Boolean.TRUE.equals(vehicle.getActive())) {
            throw new IllegalArgumentException("active vehicles");
        }

        // 🔹 LOAD MANAGED GARAGE
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        // 🔹 DATE VALIDATION
        if (entry.getServiceDate() == null ||
                entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        // 🔹 ODOMETER VALIDATION
        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException(">=");
                    }
                });

        // 🔹 ATTACH MANAGED ENTITIES (CRITICAL)
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
