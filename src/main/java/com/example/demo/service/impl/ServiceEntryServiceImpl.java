package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;
    private final VehicleRepository vehicleRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo,
                                   VehicleRepository vehicleRepo) {
        this.repo = repo;
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        entry.setRecordedAt(LocalDateTime.now());
        return repo.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        Vehicle v = vehicleRepo.findById(vehicleId).orElse(null);
        return v == null ? List.of() : repo.findByVehicle(v);
    }
}
