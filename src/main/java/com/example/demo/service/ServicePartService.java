package com.example.demo.service;

import com.example.demo.model.ServicePart;
import java.util.List;

public interface ServicePartService {

    // Used by controller
    ServicePart createPart(Long serviceEntryId, ServicePart part);

    // ✅ REQUIRED BY TEST CASE
    ServicePart createPart(ServicePart part);

    ServicePart getPartById(Long id);

    List<ServicePart> getPartsByEntry(Long serviceEntryId);
}
