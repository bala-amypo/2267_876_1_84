package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "garage",
    uniqueConstraints = @UniqueConstraint(columnNames = "garage_name")
)
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "garage_name", nullable = false, unique = true)
    private String garageName;

    private String address;

    private String contactNumber;

    private boolean active = true;

    // 🔹 NO-ARGS CONSTRUCTOR (REQUIRED)
    public Garage() {
    }

    // 🔹 ALL-ARGS CONSTRUCTOR
    public Garage(Long id, String garageName, String address, String contactNumber, boolean active) {
        this.id = id;
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.active = active;
    }

    // 🔹 GETTERS & SETTERS

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

    // ✅ THIS WAS MISSING
    public String getContactNumber() {
        return contactNumber;
    }

    // ✅ THIS WAS MISSING
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
