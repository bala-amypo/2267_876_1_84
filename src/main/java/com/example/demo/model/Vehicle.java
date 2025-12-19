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

    private String make;

    private String model;

    private Integer year;

    @Column(nullable = false)
    private Long ownerId;

    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    // Prevent nested output
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ServiceEntry> serviceEntries;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Timestamp.from(Instant.now());
        if (this.active == null) {
            this.active = true;
        }
    }

    // getters & setters
}
