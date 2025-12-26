package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(
            ServicePartRepository servicePartRepository,
            ServiceEntryRepository serviceEntryRepository
    ) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {

        serviceEntryRepository.findById(part.getServiceEntry().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("ServiceEntry not found"));

        if (part.getQuantity() == null || part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity");
        }

        return servicePartRepository.save(part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("ServicePart not found"));
    }

    @Override
    public List<ServicePart> getPartsForEntry(Long entryId) {
        return servicePartRepository.findByServiceEntryId(entryId);
    }
}
