package com.iritm.iritmservices.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iritm.iritmservices.Entity.Registration;
import com.iritm.iritmservices.Service.RegistrationServices;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class EmployeeController {
	
	@Autowired
	RegistrationServices registrationServices;
	
	@GetMapping("/helloww")
    public String msg(){
	  	return  "hi web service hellowwhellowwhelloww";
	  }
	
	
	@PostMapping(value="/saveregistraiondata")
	public ResponseEntity<String> saveRegistration(@RequestBody Registration registration) throws IOException {
		
	  String msg= registrationServices.addregistration(registration);
       return ResponseEntity.ok(msg);
	}
	
	@PostMapping(value="/verifyemailId")
	public ResponseEntity<String> saveRegistration(@RequestBody Registration registration,HttpServletRequest request) throws IOException, MessagingException {
	  registrationServices.register(registration, getSiteURL(request));
       return ResponseEntity.ok("Please verify email id");
	}
	
	
	private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
	
	
	
	
	
	
	
}
