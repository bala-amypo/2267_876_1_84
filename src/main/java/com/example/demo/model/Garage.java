package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "garages",
        uniqueConstraints = @UniqueConstraint(columnNames = "garage_name")
)
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "garage_name", nullable = false, unique = true)
    private String garageName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private Boolean active = true;

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
