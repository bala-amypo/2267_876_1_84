package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl {

    @Autowired
    private ServicePartRepository servicePartRepository;

    @Autowired
    private ServiceEntryRepository serviceEntryRepository;

    public ServicePart createPart(ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity");
        }

        serviceEntryRepository.findById(part.getServiceEntry().getId())
                .orElseThrow();

        return servicePartRepository.save(part);
    }
}
