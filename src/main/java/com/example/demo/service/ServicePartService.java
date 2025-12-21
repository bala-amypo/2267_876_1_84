package com.example.demo.service;

import com.example.demo.model.ServicePart;
import java.util.List;

public interface ServicePartService {

    ServicePart addPart(ServicePart part);

    ServicePart getPartById(Long id);

    List<ServicePart> getPartsByEntry(Long entryId);
}
