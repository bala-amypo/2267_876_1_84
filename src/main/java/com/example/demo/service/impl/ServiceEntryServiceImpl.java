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

import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository entryRepo,
            VehicleRepository vehicleRepo,
            GarageRepository garageRepo) {
        this.entryRepo = entryRepo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    @Override
    public ServiceEntry create(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepo.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = garageRepo.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return entryRepo.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return entryRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service entry not found"));
    }

    @Override
    public List<ServiceEntry> getByVehicle(Long vehicleId) {
        return entryRepo.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getByGarage(Long garageId) {
        return entryRepo.findByGarageId(garageId);
    }
}
