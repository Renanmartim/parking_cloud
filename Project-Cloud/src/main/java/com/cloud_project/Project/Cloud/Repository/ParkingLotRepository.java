package com.cloud_project.Project.Cloud.Repository;

import com.cloud_project.Project.Cloud.Entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

}
