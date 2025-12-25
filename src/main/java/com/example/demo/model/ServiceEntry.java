package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    private String serviceType;

    private LocalDate serviceDate;

    private Integer odometerReading;

    private String description;

    private LocalDateTime recordedAt;

    @PrePersist
    public void onCreate() {
        this.recordedAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Garage getGarage() { return garage; }
    public String getServiceType() { return serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }
    public String getDescription() { return description; }
    public LocalDateTime getRecordedAt() { return recordedAt; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setGarage(Garage garage) { this.garage = garage; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
    public void setDescription(String description) { this.description = description; }
}
