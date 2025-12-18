package com.example.demo.model;


import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
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
private Timestamp createdAt = new Timestamp(System.currentTimeMillis());


public Vehicle() {}


public Long getId() { return id; }
public String getVin() { return vin; }
public Boolean getActive() { return active; }
public void setActive(Boolean active) { this.active = active; }
}