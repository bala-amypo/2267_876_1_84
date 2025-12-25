package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartServiceImpl(ServicePartRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServicePart create(ServicePart part) {
        return repo.save(part);
    }

    @Override
    public ServicePart getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ServicePart> getByServiceEntry(Long serviceEntryId) {
        return repo.findByServiceEntryId(serviceEntryId);
    }
}
