package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_entry_id")
    private ServiceEntry serviceEntry;

    @CreationTimestamp
    private LocalDateTime verifiedAt;

    @NotBlank
    private String verifiedBy;

    public VerificationLog() {}

    public VerificationLog(Long serviceEntryId, String verifiedBy) {
        if (serviceEntryId != null) {
            this.serviceEntry = new ServiceEntry();
            this.serviceEntry.setId(serviceEntryId);
        }
        this.verifiedBy = verifiedBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }

    public String getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(String verifiedBy) { this.verifiedBy = verifiedBy; }
}
