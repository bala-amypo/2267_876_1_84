package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import jakarta.persistence.EntityNotFoundException;

public class ServicePartServiceImpl {

    private final ServicePartRepository partRepo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository p, ServiceEntryRepository e) {
        this.partRepo = p;
        this.entryRepo = e;
    }

    public ServicePart createPart(ServicePart part) {
        entryRepo.findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity");
        }
        return partRepo.save(part);
    }
}
