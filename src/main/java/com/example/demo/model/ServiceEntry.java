package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @NotBlank
    private String serviceType;

    @NotNull
    @PastOrPresent
    private LocalDate serviceDate;

    @NotNull
    @Positive
    private Long odometerReading;

    @NotNull
    @Positive
    private BigDecimal cost;

    @Lob
    @Size(max = 2000)
    private String notes;

    @CreationTimestamp
    private LocalDateTime submittedAt;

    public ServiceEntry() {}

    public ServiceEntry(Long vehicleId, Long garageId, String serviceType, LocalDate serviceDate, Long odometerReading, BigDecimal cost) {
        if (vehicleId != null) {
            this.vehicle = new Vehicle();
            this.vehicle.setId(vehicleId);
        }
        if (garageId != null) {
            this.garage = new Garage();
            this.garage.setId(garageId);
        }
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.cost = cost;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Garage getGarage() { return garage; }
    public void setGarage(Garage garage) { this.garage = garage; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

    public Long getOdometerReading() { return odometerReading; }
    public void setOdometerReading(Long odometerReading) { this.odometerReading = odometerReading; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
