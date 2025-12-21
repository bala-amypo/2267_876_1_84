package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "garages")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String garageName;
    private String address;
    private String contactNumber;
    private Boolean active = true;
}