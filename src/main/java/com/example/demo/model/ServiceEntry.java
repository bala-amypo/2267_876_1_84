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

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Garage garage;

    private String serviceType;
    private LocalDate serviceDate;
    private Integer odometerReading;
    private String description;

    private LocalDateTime recordedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "serviceEntry")
    private List<ServicePart> parts;

    @OneToMany(mappedBy = "serviceEntry")
    private List<VerificationLog> logs;

    public ServiceEntry() {}

    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Garage getGarage() { return garage; }
    public void setGarage(Garage garage) { this.garage = garage; }
    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
}
