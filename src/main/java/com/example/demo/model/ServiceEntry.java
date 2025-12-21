package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;
    
    private LocalDate serviceDate;
    private int odometerReading;

    @OneToMany(mappedBy = "serviceEntry")
    private List<ServicePart> serviceParts;

    @OneToMany(mappedBy = "serviceEntry")
    private List<VerificationLog> verificationLogs;

   

    public ServiceEntry() {
    }

    public ServiceEntry(Long id, Vehicle vehicle, Garage garage,
                        LocalDate serviceDate, int odometerReading) {
        this.id = id;
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Garage getGarage() { return garage; }
    public void setGarage(Garage garage) { this.garage = garage; }

    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

    public int getOdometerReading() { return odometerReading; }
    public void setOdometerReading(int odometerReading) { this.odometerReading = odometerReading; }
}
