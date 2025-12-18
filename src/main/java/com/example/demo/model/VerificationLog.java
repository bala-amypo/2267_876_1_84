package com.example.demo.model;


import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
public class VerificationLog {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private ServiceEntry serviceEntry;


private Timestamp verifiedAt = new Timestamp(System.currentTimeMillis());
private Boolean verifiedBySystem = true;
private String notes;
}