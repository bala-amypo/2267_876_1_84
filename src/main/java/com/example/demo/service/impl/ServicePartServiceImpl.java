package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service   // ✅ THIS WAS MISSING
public class ServicePartServiceImpl {

    private final ServicePartRepository partRepo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(
            ServicePartRepository partRepo,
            ServiceEntryRepository entryRepo
    ) {
        this.partRepo = partRepo;
        this.entryRepo = entryRepo;
    }

    public ServicePart createPart(ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity");
        }

        entryRepo.findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        return partRepo.save(part);
    }
}
