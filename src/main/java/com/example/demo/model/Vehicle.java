package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "vin")
    }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column
    private Integer year;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<ServiceEntry> serviceEntries;

    public Vehicle() {}

    // Automatically set createdAt on insert
    @PrePersist
    protected void onCreate() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
