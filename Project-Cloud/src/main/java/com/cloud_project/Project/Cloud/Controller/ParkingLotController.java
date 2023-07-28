package com.cloud_project.Project.Cloud.Controller;

import com.cloud_project.Project.Cloud.Entity.Car;
import com.cloud_project.Project.Cloud.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping()
    public List<Car> getAllCarsInParkingLot() {
        return parkingLotService.getAllCarsInParkingLot();
    }

    @PostMapping("/entry")
    public void carEntry(@RequestBody Car car) {
        parkingLotService.carEntry(car);
    }

    @PostMapping("/exit")
    public double carExit(@RequestBody Car car) {
        return parkingLotService.calculateParkingCharge(car);
    }
}

