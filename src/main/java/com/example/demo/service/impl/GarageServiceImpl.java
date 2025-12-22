package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        if (garageRepository.findByName(garage.getName()).isPresent()) {
            throw new IllegalArgumentException("Garage name must be unique");
        }
        return garageRepository.save(garage);
    }
}
