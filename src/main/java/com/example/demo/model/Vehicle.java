package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vin;

    private String make;
    private String model;
    private Integer year;
    private Long ownerId;
    private Boolean active;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ServiceEntry> serviceEntries;

    public Vehicle() {
    }

    public Vehicle(String vin, String make, String model, Integer year, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerId = ownerId;
        this.active = active;
    }

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

    public List<ServiceEntry> getServiceEntries() { return serviceEntries; }
    public void setServiceEntries(List<ServiceEntry> serviceEntries) { this.serviceEntries = serviceEntries; }
}
