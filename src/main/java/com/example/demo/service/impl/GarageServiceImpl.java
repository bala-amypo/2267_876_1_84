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
    public Garage create(Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public List<Garage> getAll() {
        return garageRepository.findAll();
    }

    @Override
    public Garage getById(Long id) {
        return garageRepository.findById(id).orElse(null);
    }
}
