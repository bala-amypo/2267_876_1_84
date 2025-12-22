package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    // ✅ Create Garage (unique name check)
    @Override
    public Garage createGarage(Garage garage) {

        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage name already exists");
        }

        garage.setActive(true);
        return garageRepository.save(garage);
    }

    // ✅ Update Garage
    @Override
    public Garage updateGarage(Long id, Garage updatedGarage) {

        Garage existing = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        existing.setGarageName(updatedGarage.getGarageName());
        existing.setAddress(updatedGarage.getAddress());
        existing.setContactNumber(updatedGarage.getContactNumber());

        return garageRepository.save(existing);
    }

    // ✅ Deactivate Garage (soft delete)
    @Override
    public Garage deactivateGarage(Long id) {

        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        garage.setActive(false);
        return garageRepository.save(garage);
    }

    // ✅ Get Garage by ID
    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));
    }

    // ✅ Get all garages
    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }
}
