package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String garageName;

    private String address;
    private String contactNumber;
    private Boolean active = true;

    @OneToMany(mappedBy = "garage")
    private List<ServiceEntry> serviceEntries;

    public Garage() {}

    public Long getId() { return id; }
    public String getGarageName() { return garageName; }
    public void setGarageName(String garageName) { this.garageName = garageName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
