package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repository;

    public GarageServiceImpl(GarageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        garage.setActive(true);
        return repository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setGarageName(garage.getGarageName());
        existing.setAddress(garage.getAddress());
        existing.setContactNumber(garage.getContactNumber());
        return repository.save(existing);
    }

    @Override
    public Garage getGarageById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Garage> getAllGarages() {
        return repository.findAll();
    }

    @Override
    public Garage deactivateGarage(Long id) {
        Garage garage = repository.findById(id).orElse(null);
        if (garage != null) {
            garage.setActive(false);
            return repository.save(garage);
        }
        return null;
    }
}
