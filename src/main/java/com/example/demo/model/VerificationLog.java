package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String remarks;
    private LocalDateTime verifiedAt;

    @ManyToOne
    @JoinColumn(name = "service_entry_id")
    private ServiceEntry serviceEntry;

    public VerificationLog() {
    }

    public VerificationLog(Long id, String status, String remarks,
                           LocalDateTime verifiedAt, ServiceEntry serviceEntry) {
        this.id = id;
        this.status = status;
        this.remarks = remarks;
        this.verifiedAt = verifiedAt;
        this.serviceEntry = serviceEntry;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
}
