package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    public ServicePart() {
    }

    public ServicePart(ServiceEntry serviceEntry, String partName, Integer quantity) {
        this.serviceEntry = serviceEntry;
        this.partName = partName;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
}
