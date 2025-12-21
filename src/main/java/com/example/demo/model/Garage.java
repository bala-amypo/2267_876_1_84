package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String garageName;

    private String address;
    private String contactNumber;

    @Column(nullable = false)
    private Boolean active = true;

    // 🔗 One Garage → Many ServiceEntries
    @OneToMany(
        mappedBy = "garage",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonManagedReference
    private List<ServiceEntry> serviceEntries;

    // getters & setters
    public Long getId() { return id; }

    public String getGarageName() { return garageName; }
    public void setGarageName(String garageName) { this.garageName = garageName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public List<ServiceEntry> getServiceEntries() { return serviceEntries; }
    public void setServiceEntries(List<ServiceEntry> serviceEntries) {
        this.serviceEntries = serviceEntries;
    }
}
