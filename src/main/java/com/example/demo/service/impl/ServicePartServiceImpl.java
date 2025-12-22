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

    // ================= CREATE =================

    @Override
    public ServicePart createPart(ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        return repository.save(part);
    }

    @Override
    public ServicePart createPart(Long serviceEntryId, ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        return repository.save(part);
    }

    // ================= READ =================

    @Override
    public ServicePart getPartById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ServicePart> getPartsByEntry(Long serviceEntryId) {
        return repository.findByServiceEntryId(serviceEntryId);
    }

    // ================= DELETE =================

    @Override
    public void deletePart(Long id) {
        repository.deleteById(id);
    }
}
