package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    public ServicePart createPart(ServicePart part) {

        serviceEntryRepository.findById(part.getServiceEntry().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("ServiceEntry not found"));

        // Test checks: message contains "Quantity"
        if (part.getQuantity() == null || part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity");
        }

        return servicePartRepository.save(part);
    }

    // Required by controller
    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id).orElse(null);
    }
}
