package com.cloud_project.Project.Cloud.Service;

import com.cloud_project.Project.Cloud.Entity.Car;
import com.cloud_project.Project.Cloud.Entity.ParkingLot;
import com.cloud_project.Project.Cloud.Repository.CarRepository;
import com.cloud_project.Project.Cloud.Repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ParkingLotService {
    private final CarRepository carRepository;
    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(CarRepository carRepository, ParkingLotRepository parkingLotRepository) {
        this.carRepository = carRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<Car> getAllCarsInParkingLot() {
        return carRepository.findAllPerson();
    }

    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void carEntry(Car car) {
        Car entryCar = carRepository.findByLicensePlate(car.getLicensePlate());

        if (entryCar == null) {
            car.setEntryTime(LocalDateTime.now());
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setCarSpot(generateRandomNumber(1,100));
            car.setParkingLot(parkingLot);
            parkingLotRepository.save(parkingLot);
            carRepository.save(car);
        }
    }

    public double calculateParkingCharge(Car car) {
        Car existingCar = carRepository.findByLicensePlate(car.getLicensePlate());
        if (existingCar != null) {
            existingCar.setExitTime(LocalDateTime.now());
            carRepository.save(existingCar);
        }

        LocalDateTime entryTime = existingCar.getEntryTime();
        LocalDateTime exitTime = existingCar.getExitTime();

        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();

        if (hours <= 1){
            return 8.0;
        }

        return 5.0 * hours;
    }
}
