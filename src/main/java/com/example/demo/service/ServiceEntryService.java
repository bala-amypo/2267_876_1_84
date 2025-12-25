package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry create(ServiceEntry entry);

    List<ServiceEntry> getByVehicleAndDateRange(
            Long vehicleId,
            LocalDate from,
            LocalDate to
    );
}
