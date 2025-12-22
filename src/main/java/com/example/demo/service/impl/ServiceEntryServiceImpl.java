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
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        return repository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return repository.findAll();
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesByVehicle(Long vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getEntriesByGarage(Long garageId) {
        return repository.findByGarageId(garageId);
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry serviceEntry) {
        ServiceEntry existing = getServiceEntryById(id);

        existing.setServiceDate(serviceEntry.getServiceDate());
        existing.setNotes(serviceEntry.getNotes());
        existing.setAmount(serviceEntry.getAmount());

        return repository.save(existing);
    }

    @Override
    public void deleteServiceEntry(Long id) {
        repository.deleteById(id);
    }
}
