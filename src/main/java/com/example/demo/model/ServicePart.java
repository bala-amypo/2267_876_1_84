package com.example.demo.model;

public class ServicePart {

    private Long id;
    private Long serviceEntryId;
    private String partName;
    private Integer quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getServiceEntryId() { return serviceEntryId; }
    public void setServiceEntryId(Long serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
    }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
