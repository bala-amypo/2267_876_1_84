package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.impl.ServicePartServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartServiceImpl servicePartService;

    public ServicePartController(ServicePartServiceImpl servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return servicePartService.createPart(part);
    }
}
