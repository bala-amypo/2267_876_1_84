package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {

        garageRepository.findByGarageName(garage.getGarageName())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Garage name must be unique");
                });

        garage.setActive(true);
        return garageRepository.save(garage);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));
    }

    // ✅ ADD THIS METHOD
    @Override
    public void deactivateGarage(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        garage.setActive(false);
        garageRepository.save(garage);
    }
}
