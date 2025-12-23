package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private Integer quantity;

    public ServicePart() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
