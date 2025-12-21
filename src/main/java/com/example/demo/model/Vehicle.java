package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active;

    // One Vehicle -> Many ServiceEntries (DB only, not API)
    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<ServiceEntry> serviceEntries;

    // Constructors
    public Vehicle() {}

    public Vehicle(String vin, String make, String model, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.ownerId = ownerId;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
