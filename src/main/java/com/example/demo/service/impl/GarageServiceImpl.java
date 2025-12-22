package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage name must be unique");
        }
        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage updatedGarage) {
        Garage existing = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        existing.setGarageName(updatedGarage.getGarageName());
        existing.setLocation(updatedGarage.getLocation());
        existing.setContactNumber(updatedGarage.getContactNumber());

        return garageRepository.save(existing);
    }

    @Override
    public Garage deactivateGarage(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        garage.setActive(false);
        return garageRepository.save(garage);
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }
}
