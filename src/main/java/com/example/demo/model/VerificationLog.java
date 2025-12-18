package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private Timestamp verifiedAt;
    private Boolean verifiedBySystem = true;
    private String notes;

    public VerificationLog() {
    }

    public VerificationLog(Long id, ServiceEntry serviceEntry,
                           Timestamp verifiedAt, Boolean verifiedBySystem,
                           String notes) {
        this.id = id;
        this.serviceEntry = serviceEntry;
        this.verifiedAt = verifiedAt;
        this.verifiedBySystem = verifiedBySystem;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ServiceEntry getServiceEntry() {
        return serviceEntry;
    }
    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
    public Timestamp getVerifiedAt() {
        return verifiedAt;
    }
    public void setVerifiedAt(Timestamp verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
    public Boolean getVerifiedBySystem() {
        return verifiedBySystem;
    }
    public void setVerifiedBySystem(Boolean verifiedBySystem) {
        this.verifiedBySystem = verifiedBySystem;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
