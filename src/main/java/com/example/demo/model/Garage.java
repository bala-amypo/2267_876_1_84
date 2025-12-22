package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "garages",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "garage_name")
    }
)
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "garage_name", nullable = false, unique = true)
    private String garageName;

    @Column(nullable = false)
    private String address;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private boolean active;

    // ✅ REQUIRED: No-Args Constructor
    public Garage() {
    }

    // ✅ Optional: All-Args Constructor
    public Garage(String garageName, String address, String contactNumber, boolean active) {
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.active = active;
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
