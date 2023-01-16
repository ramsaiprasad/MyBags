package com.example.LiveProject.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.LiveProject.Model.Dataa;
@Repository
public interface DataaRepository extends JpaRepository<Dataa, Integer>{
	@Query("select d from Dataa d where d.vehicleNo=:vehicleNo")
	List<Dataa> findByVehicle(@Param("vehicleNo") String no);

	@Query("select d from Dataa d where d.ld between :startdate and  :enddate")
	List<Dataa> findByDate(@Param("startdate") LocalDate dstd,@Param("enddate") LocalDate dedt);

}
