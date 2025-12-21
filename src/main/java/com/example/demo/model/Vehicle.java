package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String vin;
    private String make;
    private String model;
    private Integer year;
    @Column(nullable = false)
    private Long ownerId;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
}