package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryServiceImpl(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServiceEntry create(ServiceEntry entry) {
        return repo.save(entry);
    }

    @Override
    public List<ServiceEntry> getByVehicleAndDateRange(
            Long vehicleId,
            LocalDate from,
            LocalDate to
    ) {
        return repo.findByVehicleIdAndServiceDateBetween(vehicleId, from, to);
    }
}
