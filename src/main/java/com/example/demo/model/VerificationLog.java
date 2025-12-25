package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serviceEntryId;
    private String status;
    private String verifiedBy;
    private LocalDateTime verifiedAt = LocalDateTime.now();

    // REQUIRED BY TESTS
    public Long getServiceEntryId() {
        return serviceEntryId;
    }

    public void setServiceEntryId(Long serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // getters
    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(String verifiedBy) { this.verifiedBy = verifiedBy; }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
}
