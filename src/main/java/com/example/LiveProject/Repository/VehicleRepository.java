package com.example.LiveProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.LiveProject.Model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	@Query("SELECT u FROM Vehicle u WHERE u.vehicle_no = :vehicle_no")
	Vehicle findVehicle(
	  @Param("vehicle_no") String vno);
	

}
