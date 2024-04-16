package com.iritm.iritmservices.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iritm.iritmservices.Dto.RequestDto;
import com.iritm.iritmservices.Dto.ResponseDto;
import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Entity.MstDivision;
import com.iritm.iritmservices.Entity.MstZone;
import com.iritm.iritmservices.Entity.Registration;
import com.iritm.iritmservices.Service.RegistrationServices;
import com.iritm.iritmservices.Service.ZoneServices;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class EmployeeController {
	
	@Autowired
	RegistrationServices registrationServices;
	@Autowired
	ZoneServices zoneServices;
	
	@GetMapping("/helloww")
    public String msg(){
	  	return  "hi web service hellowwhellowwhelloww";
	  }
	
	 @GetMapping("/getzone")
	 public ResponseEntity<List<MstZone>> getzone() {
	     List<MstZone> zonelist = zoneServices.getzone();
	     if (zonelist.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     return ResponseEntity.ok(zonelist);
	 }
	 @GetMapping("/getzonebytype/{zncd}")
	 public ResponseEntity<List<MstZone>> getzonebytype(@PathVariable String zncd) {
		// String type=requestDto.getZncd();
	     List<MstZone> zonelist = zoneServices.getzonebytype(zncd);
	     if (zonelist.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     return ResponseEntity.ok(zonelist);
	 }
	 
	 @GetMapping("/getdivision/{zncd}")
	 public ResponseEntity<List<MstDivision>> getdivisionbyzncd(@PathVariable String zncd) {
		//String zncd= requestDto.getZncd();
	     List<MstDivision> zonelist = zoneServices.getdivisionbytzncd(zncd);
	     if (zonelist.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     return ResponseEntity.ok(zonelist);
	 }
	 
	
	
	@PostMapping(value="/saveregistraiondata")
	public ResponseEntity<ResponseDto> saveRegistration(@RequestBody Registration registration) throws IOException {
		
	  String msg= registrationServices.addregistration(registration);
	  ResponseDto dto=new ResponseDto();
	  dto.setMsg(msg);
       return ResponseEntity.ok(dto);
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
