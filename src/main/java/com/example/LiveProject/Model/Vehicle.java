package com.example.LiveProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "vechile_number")
	private String vehicle_no;
	@Column(name = "bags_count")
	private int bags_count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public int getBags_count() {
		return bags_count;
	}

	public void setBags_count(int bags_count) {
		this.bags_count = bags_count;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getVehicle_no()+"  "+getBags_count()+"  "+getId();
	}

}
