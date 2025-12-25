package com.example.demo.model;

import java.time.LocalDateTime;

public class VerificationLog {

    private Long id;
    private Long serviceEntryId;
    private String verifiedBy;
    private LocalDateTime verifiedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getServiceEntryId() { return serviceEntryId; }
    public void setServiceEntryId(Long serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
    }

    public String getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
}
