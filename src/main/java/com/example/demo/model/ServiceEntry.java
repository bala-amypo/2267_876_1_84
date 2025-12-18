package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many service entries → one vehicle
    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    // Many service entries → one garage
    @ManyToOne(optional = false)
    @JoinColumn(name = "garage_id")
    private Garage garage;

    private String serviceType;

    @Temporal(TemporalType.DATE)
    private Date serviceDate;

    private Integer odometerReading;

    private String description;

    private Timestamp recordedAt;

    public ServiceEntry() {}

    public ServiceEntry(Vehicle vehicle, Garage garage, String serviceType,
                        Date serviceDate, Integer odometerReading,
                        String description, Timestamp recordedAt) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
        this.recordedAt = recordedAt;
    }

    // Getters only for immutability (no setters for update/delete)
    public Long getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getRecordedAt() {
        return recordedAt;
    }
}
