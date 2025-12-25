package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repository;

    public ServiceEntryServiceImpl(ServiceEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntry create(ServiceEntry entry) {
        return repository.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ServiceEntry> getByVehicle(Long vehicleId) {
        return repository.findByVehicle_Id(vehicleId);
    }

    @Override
    public List<ServiceEntry> getByGarage(Long garageId) {
        return repository.findByGarage_Id(garageId);
    }
}
