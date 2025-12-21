package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Many ServiceEntries → One Vehicle
    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    @JsonBackReference
    private Vehicle vehicle;

    // 🔗 Many ServiceEntries → One Garage
    @ManyToOne(optional = false)
    @JoinColumn(name = "garage_id")
    @JsonBackReference
    private Garage garage;

    private String serviceType;

    private LocalDate serviceDate;

    private Integer odometerReading;

    private String description;

    @Column(nullable = false, updatable = false)
    private Instant recordedAt;

    @PrePersist
    public void onCreate() {
        this.recordedAt = Instant.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Garage getGarage() { return garage; }
    public void setGarage(Garage garage) { this.garage = garage; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getOdometerReading() { return odometerReading; }
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getRecordedAt() { return recordedAt; }
}
