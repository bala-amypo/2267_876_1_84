package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_entries")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ServiceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;
    private String serviceType;
    private LocalDate serviceDate;
    private Integer odometerReading;
    private String description;
    private LocalDateTime recordedAt = LocalDateTime.now();
}