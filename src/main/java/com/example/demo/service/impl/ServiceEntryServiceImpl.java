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

    // ✅ Constructor Injection (MANDATORY)
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    // ================= CREATE =================
    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        // 1️⃣ Fetch Vehicle
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));

        // 2️⃣ Check Vehicle Active
        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("active vehicles");
        }

        // 3️⃣ Fetch Garage
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Garage not found"));

        // 4️⃣ Check Garage Active
        if (!garage.getActive()) {
            throw new IllegalArgumentException("active garages");
        }

        // 5️⃣ Future Date Validation
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        // 6️⃣ Odometer Validation (>= last reading)
        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(lastEntry -> {
                    if (entry.getOdometerReading() < lastEntry.getOdometerReading()) {
                        throw new IllegalArgumentException(">=");
                    }
                });

        // 7️⃣ Reattach managed entities
        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        // 8️⃣ Save & return
        return serviceEntryRepository.save(entry);
    }

    // ================= READ =================
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
