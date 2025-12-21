package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    ServiceEntry getServiceEntryById(Long id);

    List<ServiceEntry> getEntriesByVehicle(Long vehicleId);

    List<ServiceEntry> getEntriesByGarage(Long garageId);
}
