package com.example.demo.service;

import com.example.demo.model.ServicePart;
import java.util.List;

public interface ServicePartService {

    ServicePart create(ServicePart part);
    ServicePart getById(Long id);
    List<ServicePart> getByServiceEntry(Long serviceEntryId);
}
