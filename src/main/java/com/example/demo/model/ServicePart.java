package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceEntryId;
    private String partName;
    private int quantity;
    private double cost;

    // REQUIRED BY TESTS
    public Long getServiceEntryId() {
        return serviceEntryId;
    }

    public void setServiceEntryId(Long serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
