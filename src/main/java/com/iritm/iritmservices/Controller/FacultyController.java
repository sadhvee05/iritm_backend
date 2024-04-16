package com.iritm.iritmservices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Entity.Faculty;
import com.iritm.iritmservices.Service.FacultyServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class FacultyController {
	@Autowired FacultyServices facultyServices;
	
	@GetMapping("/faculty")
    public String msg(){
	  	return  "hi faculty services";
	  }
	
	

	 @PostMapping ("/addFaculty")
	    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
		 Faculty addprofessor= facultyServices.saveFaculty(faculty);
		 addprofessor.setFmsg("Faculty details save successfully");
	        return ResponseEntity.ok(addprofessor);
	    }

	 @GetMapping("/getallFaculty")
	 public ResponseEntity<List<Faculty>> getAllFaculty() {
	     List<Faculty> Professor = facultyServices.getAllFaculty();
	     if (Professor.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     return ResponseEntity.ok(Professor);
	 }
	 
	  @GetMapping("/getFaculty/{id}")
	    public ResponseEntity<Faculty> getFacultyById(@PathVariable int id) {
	        Optional<Faculty> coordinator = facultyServices.getFacultyById(id);
	        return coordinator.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	  
	  
	  @PutMapping("/editFaculty/{id}")
	    public ResponseEntity<Faculty> updateFaculty(
	            @PathVariable int id,
	            @RequestBody Faculty faculty) {
	        Optional<Faculty> existingProfessor = facultyServices.getFacultyById(id);
	        
	        System.out.println("show data "+existingProfessor.get().getFemailid());
	        if (existingProfessor.isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        // Update the fields as needed
	        Faculty facultyToUpdate = existingProfessor.get();
	        facultyToUpdate.setFname(faculty.getFname());
	        facultyToUpdate.setFempid(faculty.getFempid());
	        facultyToUpdate.setFmobileno(faculty.getFmobileno());
	        facultyToUpdate.setFemailid(faculty.getFemailid());

	        // Save the updated coordinator
	        Faculty savedProfessor = facultyServices.saveFaculty(facultyToUpdate);
	        savedProfessor.setFmsg("Update Successfully");
	        return ResponseEntity.ok(savedProfessor);
}
	  
	  @DeleteMapping("/delfaculty/{id}")
	    public ResponseEntity<Faculty> deleteFaculty(@PathVariable int id) {
	        Optional<Faculty> existingFaculty = facultyServices.getFacultyById(id);
	        if (existingFaculty.isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
       String msg=  facultyServices.deleteFaculty(id);
       Faculty faculty=new Faculty();
       faculty.setFmsg(msg);
	        return ResponseEntity.ok(faculty);
	    }
	  

	
	 
	  
	
}
