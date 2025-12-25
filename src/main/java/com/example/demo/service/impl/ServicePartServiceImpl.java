package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;

    public ServicePartServiceImpl(ServicePartRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServicePart createPart(ServicePart part) {
        return repo.save(part);
    }
}
