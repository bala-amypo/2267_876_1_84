package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repository;

    public ServicePartServiceImpl(ServicePartRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServicePart createPart(Long serviceEntryId, ServicePart part) {

        // ✅ PASTE THIS CHECK EXACTLY HERE (FIRST LINE)
        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        return repository.save(part);
    }
}
