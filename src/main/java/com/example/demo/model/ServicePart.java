package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "service_entry_id")
    private ServiceEntry serviceEntry;

    public ServicePart() {
    }

    public ServicePart(Long id, String partName, double cost, ServiceEntry serviceEntry) {
        this.id = id;
        this.partName = partName;
        this.cost = cost;
        this.serviceEntry = serviceEntry;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
}
