package com.example.LiveProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.ApplicationException;
import com.example.Exceptions.ApplicationExceptionFactory;
import com.example.Exceptions.ApplicationExceptionList;
import com.example.LiveProject.DAO.DataaModel;
import com.example.LiveProject.DAO.DateRange;
import com.example.LiveProject.DAO.LoginRequest;
import com.example.LiveProject.DAO.SignInRequest;
import com.example.LiveProject.Model.Dataa;
import com.example.LiveProject.Model.SignUpRequest;
import com.example.LiveProject.Model.Vehicle;

import com.example.LiveProject.Service.PayloadService;
import com.example.LiveProject.Service.SecurityService;



@RestController
@RequestMapping("api/test")
@CrossOrigin(origins ="*")
public class SigninController {
    
    @Autowired
	 PayloadService ms;
    @Autowired
     ApplicationExceptionFactory exceptionFactory;

     @Autowired
     SecurityService sc;
     
    @GetMapping("/getTestData")
    public ResponseEntity<?> sendSampleDataToFrontEnd()
    {
        return new ResponseEntity<String>("A Message from RestController To React App",HttpStatus.OK);
    }

    @PostMapping("saveData")
    public ResponseEntity<?> saveData(@RequestBody DataaModel data) throws ApplicationException,ApplicationExceptionList
    {
        System.out.println(data.getBagscount());
        System.out.println(data.getNoofpoints());
        System.out.println(data.getPhoneNumber());
        System.out.println(data.getVehicleNo());
        ms.saveDataa(data);
        
        return new ResponseEntity<String>("Data Submitted Succesfully",HttpStatus.OK);
    }
    @GetMapping("/getDatea")
    public ResponseEntity<?> getAllData() throws ApplicationException,ApplicationExceptionList
    {
        return new ResponseEntity<List<Dataa>>(ms.getAllData(),HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchByVehicalId(@PathVariable("id") String id) throws ApplicationException, ApplicationExceptionList
    {
        List<Dataa> list=ms.getAllVehiclebyVehicleno(id);
        return new ResponseEntity<List<Dataa>>(list,HttpStatus.OK);
    }
    @PostMapping("/get_by_date_range")
    public ResponseEntity<?> getByDateRange(@RequestBody DateRange range) throws ApplicationException, ApplicationExceptionList
    {
        List<Dataa> list=ms.getByDate(range.getStartDate(),range.getEndDate());

        return new ResponseEntity<List<Dataa>>(list,HttpStatus.OK);

    }
    @GetMapping("/get_all_vehicle")
    public ResponseEntity<?> getAllVehicals() throws ApplicationException, ApplicationExceptionList
    {
        List<Vehicle> list=ms.getAllVehicle();
        return new ResponseEntity<List<Vehicle>>(list,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signinUser(@RequestBody LoginRequest request)
    {
      
      return ResponseEntity.ok(sc.verifyUserDetails(request));
    }
    @PostMapping("/signUp")
    public ResponseEntity<?> signUpUser(@RequestBody SignInRequest request)
    {
        sc.signUpUser(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
  @GetMapping("/getByVehical/{vehicalNo}")
	public ResponseEntity<List<Dataa>> getByVehicle(@PathVariable("vehicalNo") String vehicalNo) throws ApplicationException, ApplicationExceptionList
	{
		//System.out.println(no);
		List<Dataa> list=ms.getAllVehiclebyVehicleno(vehicalNo);
		//System.out.println(list);
		return new ResponseEntity<List<Dataa>>(list,HttpStatus.OK);
	}

    @GetMapping("/getByDate/{startDate}/{endDate}")
	public ResponseEntity<List<Dataa>> getByVehicle(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) throws ApplicationException, ApplicationExceptionList
	{
		//System.out.println(no);
		List<Dataa> list=ms.getByDate(startDate,endDate);
		//System.out.println(list);
		return new ResponseEntity<List<Dataa>>(list,HttpStatus.OK);
	}
}
