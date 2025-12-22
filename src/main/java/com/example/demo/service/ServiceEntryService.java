package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry serviceEntry);

    List<ServiceEntry> getAllServiceEntries();

    ServiceEntry getServiceEntryById(Long id);

    ServiceEntry updateServiceEntry(Long id, ServiceEntry serviceEntry);

    void deleteServiceEntry(Long id);
}
