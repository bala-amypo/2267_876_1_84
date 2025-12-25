package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private static final Map<Long, ServicePart> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @Override
    public ServicePart create(ServicePart part) {
        long id = idGen.getAndIncrement();
        part.setId(id);
        store.put(id, part);
        return part;
    }

    @Override
    public ServicePart getById(Long id) {
        return store.get(id);
    }

    @Override
    public List<ServicePart> getByServiceEntry(Long serviceEntryId) {
        List<ServicePart> list = new ArrayList<>();
        for (ServicePart p : store.values()) {
            if (serviceEntryId.equals(p.getServiceEntryId())) {
                list.add(p);
            }
        }
        return list;
    }
}
    