package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String garageName;

    private String address;

    private boolean active = true;

    // ===== Constructors =====
    public Garage() {}

    public Garage(String garageName, String address) {
        this.garageName = garageName;
        this.address = address;
        this.active = true;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 🔥 REQUIRED BY TESTS
    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        if (garageName == null || garageName.trim().isEmpty()) {
            throw new IllegalArgumentException("Garage name cannot be empty");
        }
        this.garageName = garageName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 🔥 REQUIRED BY TESTS
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
