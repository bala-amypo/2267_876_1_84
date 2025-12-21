package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vin")
)
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

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    /**
     * One Vehicle -> Many Service Entries
     * Inverse side of the relationship
     */
    @OneToMany(
        mappedBy = "vehicle",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @JsonIgnore   // 🔥 prevents recursive JSON & Swagger explosion
    private List<ServiceEntry> serviceEntries;

    // ---------- Lifecycle ----------
    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    // ---------- Constructors ----------
    public Vehicle() {}

    public Vehicle(String vin, String make, String model, Integer year, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerId = ownerId;
        this.active = active;
    }

    // ---------- Getters & Setters ----------
    public Long getId() { return id; }

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

    public Instant getCreatedAt() { return createdAt; }

    public List<ServiceEntry> getServiceEntries() { return serviceEntries; }
}
