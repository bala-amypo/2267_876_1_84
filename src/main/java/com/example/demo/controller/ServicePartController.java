package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.impl.ServicePartServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-parts")
@Tag(name = "Service Part")
public class ServicePartController {

    private final ServicePartServiceImpl servicePartService;

    public ServicePartController(ServicePartServiceImpl servicePartService) {
        this.servicePartService = servicePartService;
    }

    // POST – Add service part
    @PostMapping
    public ServicePart createPart(@RequestBody ServicePart part) {
        return servicePartService.createPart(part);
    }

    // GET – Part by ID
    @GetMapping("/{id}")
    public ServicePart getById(@PathVariable Long id) {
        return servicePartService.getPartById(id);
    }
}
