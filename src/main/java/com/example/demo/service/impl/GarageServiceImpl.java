package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    // ✅ CONSTRUCTOR REQUIRED
    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {

        if (garage.getGarageName() == null || garage.getGarageName().isBlank()) {
            throw new IllegalArgumentException("Garage name is required");
        }

        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage already exists");
        }

        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existing = getGarageById(id);

        existing.setGarageName(garage.getGarageName());
        existing.setAddress(garage.getAddress());
        existing.setContactNumber(garage.getContactNumber());

        return garageRepository.save(existing);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public void deactivateGarage(Long id) {
        Garage garage = getGarageById(id);
        garage.setActive(false);
        garageRepository.save(garage);
    }
}
