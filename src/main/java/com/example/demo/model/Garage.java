package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "garages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String garageName;

    @Column(nullable = false)
    private String address;

    @Builder.Default
    private Boolean active = true;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServiceEntry> serviceEntries;
}
