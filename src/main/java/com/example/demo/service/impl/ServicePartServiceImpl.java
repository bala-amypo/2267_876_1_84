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

    private final ServicePartRepository partRepository;
    private final ServiceEntryRepository entryRepository;

    public ServicePartServiceImpl(ServicePartRepository partRepository,
                                  ServiceEntryRepository entryRepository) {
        this.partRepository = partRepository;
        this.entryRepository = entryRepository;
    }

    // ✅ MAIN METHOD (Controller uses this)
    @Override
    public ServicePart createPart(Long serviceEntryId, ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        ServiceEntry entry = entryRepository.findById(serviceEntryId)
                .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));

        part.setServiceEntry(entry);
        return partRepository.save(part);
    }

    // ✅ OVERLOADED METHOD (Tests use this)
    @Override
    public ServicePart createPart(ServicePart part) {

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (part.getServiceEntry() == null || part.getServiceEntry().getId() == null) {
            throw new IllegalArgumentException("ServiceEntry must be provided");
        }

        return createPart(part.getServiceEntry().getId(), part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return partRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service part not found"));
    }

    @Override
    public List<ServicePart> getPartsByEntry(Long serviceEntryId) {
        return partRepository.findByServiceEntryId(serviceEntryId);
    }
}
