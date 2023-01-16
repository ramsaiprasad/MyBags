package com.example.LiveProject.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataa")
public class Dataa {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "vechile_number")
	private String vehicleNo;
	private int bags;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name = "date")
	private LocalDate ld;
	private String NoofPoints;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getBags() {
		return bags;
	}

	public void setBags(int bagscount) {
		this.bags = bagscount;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNoofPoints() {
		return NoofPoints;
	}

	public void setNoofPoints(String noofPoints) {
		NoofPoints = noofPoints;
	}
	

}
