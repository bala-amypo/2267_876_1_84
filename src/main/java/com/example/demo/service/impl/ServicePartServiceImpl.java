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

    @Override
    public ServicePart addPart(ServicePart part) {
        return repository.save(part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ServicePart> getPartsByEntry(Long entryId) {
        return repository.findByServiceEntryId(entryId);
    }
}
