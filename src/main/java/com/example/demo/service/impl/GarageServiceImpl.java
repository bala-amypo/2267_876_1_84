package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;

public class GarageServiceImpl {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("already exists");
        }
        return garageRepository.save(garage);
    }
}
