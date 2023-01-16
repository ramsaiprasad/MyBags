package com.example.LiveProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.LiveProject.SigninRepository;
import com.example.LiveProject.DAO.LoginRequest;
import com.example.LiveProject.DAO.SignInRequest;
import com.example.LiveProject.Model.SignUpRequest;



@Service
public class SecurityService {

    @Autowired
    private SigninRepository signinRepo;

    public ResponseEntity<?> verifyUserDetails(LoginRequest request)
    {
        boolean token=false;
        boolean isLoggedin=false;
       SignUpRequest req=signinRepo.finduserName(request.getUserName());
       if(req!=null)
       {
        if(req.getPassword()==request.getPassword())
        {
          token=true;
        }
       }
       if(token==true)
       {
        isLoggedin=true;
         return new ResponseEntity<Boolean>(isLoggedin, HttpStatus.OK);
       }
       else{
        return new ResponseEntity<String>("User Credentials Are Wrong", HttpStatus.OK);
       }

    }

    public ResponseEntity<?> signUpUser(SignInRequest request)
    {
       SignUpRequest requ=new SignUpRequest();
       
       requ.setEmail(request.getEmail());
       requ.setUserName(request.getUserName());
       requ.setPassword(request.getPassword());
       
       signinRepo.save(requ);

       return new ResponseEntity<String>("Sign Up SuccessFull",HttpStatus.OK);
    }


    
}
