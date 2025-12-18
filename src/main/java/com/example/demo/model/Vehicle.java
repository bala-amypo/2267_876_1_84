package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Vehicle{
    @ID
    @GeneratedValue(strategy=GenereationType.IDENTITY)
    private Long id;

    @Column(unique=true,nulltable=false)
    private String vin;

    private String make;
    private String model;
    private Integer year;

    private Long ownerId;
    private Boolean active=true;
    private Timestamp createdAt;
    public Vehicle(){
        
    }
}