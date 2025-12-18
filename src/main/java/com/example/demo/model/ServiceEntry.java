package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Garage garage;

    private String serviceType;
    private Date serviceDate;
    private Integer odometerReading;
    private String description;
    private Timestamp recordedAt;

    public ServiceEntry() {
    }

    public ServiceEntry(Long id, Vehicle vehicle, Garage garage,
                        String serviceType, Date serviceDate,
                        Integer odometerReading, String description,
                        Timestamp recordedAt) {
        this.id = id;
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
        this.recordedAt = recordedAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Garage getGarage() {
        return garage;
    }
    public void setGarage(Garage garage) {
        this.garage = garage;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public Date getServiceDate() {
        return serviceDate;
    }
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
    public Integer getOdometerReading() {
        return odometerReading;
    }
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Timestamp getRecordedAt() {
        return recordedAt;
    }
    public void setRecordedAt(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }
}
