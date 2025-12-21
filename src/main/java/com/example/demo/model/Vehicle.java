package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "vin"))
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    private String make;
    private String model;
    private Integer year;

    @Column(nullable = false)
    private Long ownerId;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "vehicle")
    private List<ServiceEntry> serviceEntries;

    public Vehicle() {}

    public Vehicle(String vin, String make, String model, Integer year, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerId = ownerId;
        this.active = active;
    }

    // getters and setters
    public Long getId() { return id; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Long getOwnerId() { return ownerId; }
}
