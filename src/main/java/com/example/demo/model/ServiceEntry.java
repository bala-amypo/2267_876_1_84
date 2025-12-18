package com.example.demo.model;


import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
public class ServiceEntry {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private Vehicle vehicle;


@ManyToOne
private Garage garage;


private String serviceType;
private Date serviceDate;
private Integer odometerReading;
private String description;


private Timestamp recordedAt = new Timestamp(System.currentTimeMillis());


public ServiceEntry() {}


public Integer getOdometerReading() { return odometerReading; }
public Date getServiceDate() { return serviceDate; }
public Vehicle getVehicle() { return vehicle; }
}