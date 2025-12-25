package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        entry.setRecordedAt(LocalDateTime.now());
        return repo.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ServiceEntry> findEntriesForVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer) {
        return repo.findByGarageIdAndOdometerReadingGreaterThanEqual(
                garageId, minOdometer
        );
    }

    @Override
    public List<ServiceEntry> findByVehicleAndDateRange(
            Long vehicleId, LocalDate from, LocalDate to) {

        return repo.findByVehicleIdAndServiceDateBetween(
                vehicleId, from, to
        );
    }
}
