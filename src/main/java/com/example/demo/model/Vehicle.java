package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    // ================= PRIMARY KEY =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ================= VEHICLE DETAILS =================
    @Column(nullable = false, unique = true)
    private String vin;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    // ================= OWNER DETAILS =================
    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private Long ownerId;   // ✅ REQUIRED for findByOwnerId()

    // ================= STATUS =================
    @Column(nullable = false)
    private boolean active = true;

    // ================= CONSTRUCTORS =================
    public Vehicle() {
        // Default constructor required by JPA
    }

    public Vehicle(String vin, String registrationNumber,
                   String ownerName, Long ownerId) {
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.active = true;
    }

    // ================= GETTERS & SETTERS =================
    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
