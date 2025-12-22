package com.example.demo.service;

import com.example.demo.model.ServicePart;
import java.util.List;

public interface ServicePartService {

    ServicePart createPart(ServicePart part);

    ServicePart createPart(Long serviceEntryId, ServicePart part);

    ServicePart getPartById(Long id);

    List<ServicePart> getPartsByEntry(Long serviceEntryId);

    void deletePart(Long id);
}
