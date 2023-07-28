package com.cloud_project.Project.Cloud.Repository;

import com.cloud_project.Project.Cloud.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByLicensePlate(String licensePlate);

    @Query("SELECT c FROM Car c WHERE c.exitTime IS NULL")
    List<Car> findAllPerson();
}