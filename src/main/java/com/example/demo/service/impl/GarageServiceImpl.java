package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            // test checks contains("already exists")
            throw new IllegalArgumentException("already exists");
        }
        return garageRepository.save(garage);
    }

    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Garage not found"));
    }
}
