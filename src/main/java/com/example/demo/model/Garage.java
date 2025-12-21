package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String garageName;
    private String address;
    private String contactNumber;
    private boolean active;

    @OneToMany(mappedBy = "garage")
    private List<ServiceEntry> serviceEntries;

    public Garage() {
    }

    public Garage(Long id, String garageName, String address,
                  String contactNumber, boolean active) {
        this.id = id;
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGarageName() { return garageName; }
    public void setGarageName(String garageName) { this.garageName = garageName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
