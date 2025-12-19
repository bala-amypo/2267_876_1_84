package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vin")
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String vin;

    @NotBlank
    @Column(nullable = false)
    private String make;

    @NotBlank
    @Column(nullable = false)
    private String model;

    @NotNull
    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServiceEntry> serviceEntries;
}
