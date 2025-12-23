package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service   // ✅ THIS IS MANDATORY
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        garageRepository.findByGarageName(garage.getGarageName())
                .ifPresent(g -> {
                    throw new IllegalArgumentException("Garage already exists");
                });
        return garageRepository.save(garage);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Garage not found"));
    }

    @Override
    public void deactivateGarage(Long id) {
        Garage g = getGarageById(id);
        g.setActive(false);
        garageRepository.save(g);
    }
}
