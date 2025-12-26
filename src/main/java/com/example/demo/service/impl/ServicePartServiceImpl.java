package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.*;

public class ServicePartServiceImpl {

    private final ServicePartRepository repo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository r,
                                  ServiceEntryRepository e) {
        this.repo = r;
        this.entryRepo = e;
    }

    public ServicePart createPart(ServicePart p) {
        if (p.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity");
        return repo.save(p);
    }
}
