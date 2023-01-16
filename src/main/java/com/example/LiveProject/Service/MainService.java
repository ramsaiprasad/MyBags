package com.example.LiveProject.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.ApplicationException;
import com.example.Exceptions.ApplicationExceptionList;
import com.example.LiveProject.DAO.DataaModel;
import com.example.LiveProject.Repository.DataaRepository;
import com.example.LiveProject.Repository.VehicleRepository;
import com.example.LiveProject.Model.Dataa;
import com.example.LiveProject.Model.Vehicle;

@Service
public class MainService {
	
	@Autowired
	DataaRepository dr;
	@Autowired
	VehicleRepository vr;
	LocalDate ld=LocalDate.now();
	
	public void saveDataa(DataaModel d) throws ApplicationException,ApplicationExceptionList
	{
		Dataa data=new Dataa();
		data.setBags(d.getBagscount());
		data.setPhoneNumber(d.getPhoneNumber());
		data.setVehicleNo(d.getVehicleNo().toUpperCase());
		data.setLd(ld);
		dr.save(data);
		Vehicle v=null;
		v=vr.findVehicle(d.getVehicleNo());
		if(v!=null)
		{
			v.setBags_count(v.getBags_count()+d.getBagscount());
			vr.save(v);
		}
		else
		{
			v=new Vehicle();
			v.setBags_count(d.getBagscount());
			v.setVehicle_no(d.getVehicleNo().toUpperCase());
			System.out.println(v.toString());
			vr.save(v);
		}
	}

	public List<Dataa> getAllData(){
		return dr.findAll();
	}

	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	public List<Dataa> getAllVehiclebyVehicleno(String no) {
		// TODO Auto-generated method stub
		return dr.findByVehicle(no);
	}

	public List<Dataa> getByDate(String std, String edt) {
		// TODO Auto-generated method stub

		LocalDate Dstd=LocalDate.parse(std);
		LocalDate Dedt=LocalDate.parse(edt);
		return dr.findByDate(Dstd,Dedt);
	}
}
