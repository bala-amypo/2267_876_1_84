package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = entry.getVehicle();

        // Rule: only active vehicles
        if (!vehicle.getActive()) {
            throw new IllegalStateException("active vehicles");
        }

        // Rule: serviceDate must not be in future
        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future");
        }

        // Rule: odometer must be >= previous
        List<ServiceEntry> previousEntries =
                serviceEntryRepository.findByVehicleId(vehicle.getId());

        if (!previousEntries.isEmpty()) {
            Integer lastReading =
                    previousEntries.get(previousEntries.size() - 1).getOdometerReading();

            if (entry.getOdometerReading() < lastReading) {
                throw new IllegalArgumentException(">=");
            }
        }

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
