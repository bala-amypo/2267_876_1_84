package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repository;

    public ServicePartServiceImpl(ServicePartRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE PART
    @Override
    public ServicePart createPart(Long serviceEntryId, ServicePart part) {

        // Test case requirement
        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        return repository.save(part);
    }

    // ✅ GET PART BY ID (FIXES CURRENT ERROR)
    @Override
    public ServicePart getPartById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ GET PARTS BY SERVICE ENTRY
    @Override
    public List<ServicePart> getPartsByEntry(Long serviceEntryId) {
        return repository.findByServiceEntryId(serviceEntryId);
    }
}
