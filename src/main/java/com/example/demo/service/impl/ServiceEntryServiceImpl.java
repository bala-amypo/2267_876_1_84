package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        return repo.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }
}
