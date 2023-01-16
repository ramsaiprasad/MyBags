package com.example.LiveProject.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Exceptions.ApplicationConstants;
import com.example.Exceptions.ApplicationException;
import com.example.Exceptions.ApplicationExceptionFactory;
import com.example.Exceptions.ApplicationExceptionList;
import com.example.Exceptions.Utilities;
import com.example.LiveProject.DAO.DataaModel;
import com.example.LiveProject.Model.Dataa;
import com.example.LiveProject.Model.Vehicle;
import com.example.LiveProject.Repository.DataaRepository;
import com.example.LiveProject.Repository.VehicleRepository;



@Component
public class PayloadService {

   @Autowired
   private ApplicationExceptionFactory applicationExceptionFactory;

   @Autowired
	DataaRepository dr;
	@Autowired
	VehicleRepository vr;
	LocalDate ld=LocalDate.now();
	
	public void saveDataa(DataaModel d) throws ApplicationException,ApplicationExceptionList
	{
        validate(d);
	}

	public List<Dataa> getAllData() throws ApplicationException{
        List<Dataa> applicationData=null;
         applicationData=dr.findAll();
         try{
         if(applicationData==null || applicationData.size()==0)
         {
            throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_NULL);
         }
        }
        catch(ApplicationException ex)
        {
            throw ex;
        }
		return applicationData;
	}

	public List<Vehicle> getAllVehicle() throws ApplicationException,ApplicationExceptionList {
		// TODO Auto-generated method stub
        List<Vehicle> vehicles=null;
        vehicles=vr.findAll();
        try{
        if(vehicles==null || vehicles.size()==0)
        {
            throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_VEHICAL);
        }
        }
        catch(ApplicationException ex)
        {
            throw ex;
        }
		return vehicles;
	}

	public List<Dataa> getAllVehiclebyVehicleno(String no) throws ApplicationException,ApplicationExceptionList {
		// TODO Auto-generated method stub
        List<Dataa> allData=null;
        try{
               allData=dr.findByVehicle(no);
               if(no==null || no.trim().length()==0)
               {
                 throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_PARAM_ID);
               }
               if(allData==null || allData.size()==0)
               {
                throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_NULL);
               } 
        }
        catch(ApplicationException ex)
        {
            throw ex;
        }
		return allData ;
	}

	public List<Dataa> getByDate(String std, String edt) throws ApplicationException,ApplicationExceptionList {
		// TODO Auto-generated method stub
        List<Dataa> allData=null;
        LocalDate Dstd=null;
        LocalDate Dedt=null;
        try{
            
            if(std==null || std.trim().length()==0)
            {
                throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_DATE);
            }
            if(edt==null || edt.trim().length()==0)
            {
                throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_DATE);
            }

             if(Utilities.validateDateFormat(std))
             {
                Dstd =LocalDate.parse(std);
              }
              else{
                throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_INVALID_DATE_FORMAT);
              }
              if(Utilities.validateDateFormat(edt))
              {
                Dedt=LocalDate.parse(edt);
              }
              else{
                throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_INVALID_DATE_FORMAT);
              }
              allData=dr.findByDate(Dstd,Dedt);
        }
        catch(ApplicationException ex)
        {
            throw ex;
            
        }
		
		return allData;
	}


    public void validate(DataaModel data) throws ApplicationException,ApplicationExceptionList
    {
        Dataa dataa=new Dataa();
        try{
        if(data.getPhoneNumber()=="1" || data.getPhoneNumber().trim().length()==0)
        {
            System.out.println("k");
              throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_PHONE);
        }
        else{
            dataa.setPhoneNumber(data.getPhoneNumber());
        }
        if(data.getVehicleNo()==null || data.getVehicleNo().trim().length()==0)
        {
            throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_VEHICAL);
        }
        else{
            dataa.setVehicleNo(data.getVehicleNo());
        }
        if(data.getBagscount()<0)
        {
            System.out.println(data.getBagscount()+"rmasi");
             throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_BAGSCOUNT);
        }
       else{
          dataa.setBags(data.getBagscount());
        }
		dataa.setLd(ld);
        int d=Integer.parseInt(data.getNoofpoints().trim());
        if(data.getNoofpoints()==null || data.getNoofpoints().trim().length()==0 || d<=0)
        {
    
            throw applicationExceptionFactory.createNewApplicationException(ApplicationConstants.ERROR_CODE_BAGSCOUNT);
        }
        else{
            dataa.setNoofPoints(data.getNoofpoints());
        }
        dr.save(dataa);
        Vehicle vehical=null;
        vehical=vr.findVehicle(data.getVehicleNo());
        if(vehical==null)
        {
            vehical=new Vehicle();
			vehical.setBags_count(data.getBagscount());
			vehical.setVehicle_no(data.getVehicleNo().toUpperCase());
			System.out.println(vehical.toString());
			vr.save(vehical);
        }
        else{
            vehical.setBags_count(vehical.getBags_count()+data.getBagscount());
			vr.save(vehical);
        }

    }
    catch(ApplicationException ex)
    {
        throw ex;
    }
    catch(IllegalArgumentException iex)
    {
        throw iex;
    }
    catch(Exception exx)
    {
        throw exx;
    }

    }
    
}
