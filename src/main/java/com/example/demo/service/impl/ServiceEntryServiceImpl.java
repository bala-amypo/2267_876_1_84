package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

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

        // 🔹 Fetch vehicle
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));

        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("Only active vehicles allowed");
        }

        // 🔹 Fetch garage
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Garage not found"));

        if (!garage.getActive()) {
            throw new IllegalArgumentException("Garage must be active");
        }

        // 🔹 Future date check
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be future");
        }

        // 🔹 Odometer validation
        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException("Odometer must be >=");
                    }
                });

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("ServiceEntry not found"));
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
