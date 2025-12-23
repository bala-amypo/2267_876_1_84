package com.example.demo.service;

import com.example.demo.model.Garage;

public interface GarageService {

    Garage createGarage(Garage garage);

    Garage getGarageById(Long id);

    void deactivateGarage(Long id);
}
