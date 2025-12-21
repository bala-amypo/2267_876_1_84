package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    private Garage garage;

    private String serviceType;

    private LocalDate serviceDate;

    private Integer odometerReading;

    private String description;

    private LocalDateTime recordedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "serviceEntry")
    private List<ServicePart> parts;

    public ServiceEntry() {}

    public ServiceEntry(Vehicle vehicle, Garage garage, String serviceType,
                        LocalDate serviceDate, Integer odometerReading) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
    }

    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Integer getOdometerReading() { return odometerReading; }
    public LocalDate getServiceDate() { return serviceDate; }
}
