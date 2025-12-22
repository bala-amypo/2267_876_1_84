package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository partRepository;
    private final ServiceEntryRepository entryRepository;

    public ServicePartServiceImpl(ServicePartRepository partRepository,
                                  ServiceEntryRepository entryRepository) {
        this.partRepository = partRepository;
        this.entryRepository = entryRepository;
    }

    @Override
    public ServicePart createPart(Long serviceEntryId, ServicePart part) {

        // ✅ TEST EXPECTS THIS EXCEPTION HERE
        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        ServiceEntry entry = entryRepository.findById(serviceEntryId)
                .orElseThrow(() -> new IllegalArgumentException("ServiceEntry not found"));

        part.setServiceEntry(entry);
        return partRepository.save(part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return partRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ServicePart not found"));
    }

    @Override
    public List<ServicePart> getPartsByEntry(Long serviceEntryId) {
        return partRepository.findByServiceEntryId(serviceEntryId);
    }
}
