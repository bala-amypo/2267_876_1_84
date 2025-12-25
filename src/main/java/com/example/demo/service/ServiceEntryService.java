package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry create(ServiceEntry entry);

    ServiceEntry getById(Long id);

    List<ServiceEntry> getByVehicle(Long vehicleId);

    List<ServiceEntry> getByGarage(Long garageId);
}
