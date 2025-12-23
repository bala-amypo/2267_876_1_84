package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl {

    private final ServicePartRepository servicePartRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository) {
        this.servicePartRepository = servicePartRepository;
    }

    public ServicePart createPart(ServicePart part) {
        if (part.getQuantity() == null || part.getQuantity() <= 0) {
            // keyword "Quantity" required
            throw new IllegalArgumentException("Quantity");
        }
        return servicePartRepository.save(part);
    }

    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id).orElse(null);
    }
}
