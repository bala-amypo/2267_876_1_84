package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repository;

    public GarageServiceImpl(GarageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        repository.findByGarageName(garage.getGarageName()).ifPresent(g -> {
            throw new IllegalArgumentException("already exists");
        });
        return repository.save(garage);
    }
}
