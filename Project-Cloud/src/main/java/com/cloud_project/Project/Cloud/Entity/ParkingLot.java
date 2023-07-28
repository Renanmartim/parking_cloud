package com.cloud_project.Project.Cloud.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_spot")
    private int carSpot;

    @JsonIgnore
    @OneToOne(mappedBy = "parkingLot")
    private Car cars;

    // Default constructor for JPA
    public ParkingLot() {
    }

    // Getters and Setters
    public Car getCars() {
        return cars;
    }

    public void setCars(Car cars) {
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCarSpot() {
        return carSpot;
    }

    public void setCarSpot(int carSpot) {
        this.carSpot = carSpot;
    }
}
