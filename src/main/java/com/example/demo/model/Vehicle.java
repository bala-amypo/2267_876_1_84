package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vehicle {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String vin;

    private String make;
    private String model;
    private Integer year;

    @Column(nullable = false)
    private Long ownerId;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters (ALL REQUIRED)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
