package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Vehicle{
    @ID
    @GeneratedValue(strategy=GenereationType.IDENTITY)
    private Long id;

    @Column(unique=true,nulltable=)
}