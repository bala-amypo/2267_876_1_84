package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.*;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.ServicePartService;

public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository r, ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public ServicePart createPart(ServicePart p) {
        entryRepo.findById(p.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("Entry not found"));

        if (p.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity");

        return repo.save(p);
    }
}
