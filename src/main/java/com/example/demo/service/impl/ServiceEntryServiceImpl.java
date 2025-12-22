package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS WHAT FIXES YOUR ERROR
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        return serviceEntryRepository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry serviceEntry) {
        ServiceEntry existing = getServiceEntryById(id);
        existing.setServiceDate(serviceEntry.getServiceDate());
        existing.setDescription(serviceEntry.getDescription());
        existing.setCost(serviceEntry.getCost());
        return serviceEntryRepository.save(existing);
    }

    @Override
    public void deleteServiceEntry(Long id) {
        serviceEntryRepository.deleteById(id);
    }
}
