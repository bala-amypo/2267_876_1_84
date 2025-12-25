package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Garage;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private static final Map<Long, ServiceEntry> store = new HashMap<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    @Override
    public ServiceEntry create(ServiceEntry entry) {
        long id = idGen.getAndIncrement();
        entry.setId(id);
        entry.setRecordedAt(java.time.LocalDateTime.now());
        store.put(id, entry);
        return entry;
    }

    @Override
    public ServiceEntry getById(Long id) {
        return store.get(id);
    }

    @Override
    public List<ServiceEntry> getByVehicle(Long vehicleId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            Vehicle v = e.getVehicle();
            if (v != null && vehicleId.equals(v.getId())) {
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public List<ServiceEntry> getByGarage(Long garageId) {
        List<ServiceEntry> list = new ArrayList<>();
        for (ServiceEntry e : store.values()) {
            Garage g = e.getGarage();
            if (g != null && garageId.equals(g.getId())) {
                list.add(e);
            }
        }
        return list;
    }
}
