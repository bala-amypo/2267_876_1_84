package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {
        ServiceEntry entry = serviceEntryRepository
                .findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));

        part.setServiceEntry(entry);
        return servicePartRepository.save(part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServicePart not found"));
    }

    @Override
    public List<ServicePart> getPartsByEntry(Long serviceEntryId) {
        return servicePartRepository.findByServiceEntryId(serviceEntryId);
    }
}
