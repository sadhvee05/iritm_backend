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
import com.iritm.iritmservices.Service.CoordinatorServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class CoordinatorController {
	
	@Autowired  
	CoordinatorServices coordinatorServices;  
	
	@GetMapping("/hellowcoordinator")
    public String msg(){
	  	return  "hi coordinator Services";
	  }

	 @PostMapping ("/addcoordinator")
	    public ResponseEntity<Coordinator> addCoordinator(@RequestBody Coordinator coordinator) {
		 Coordinator addcordinator= coordinatorServices.saveCoordinator(coordinator);
		 addcordinator.setMsg("Coordinator details save successfully");
	        return ResponseEntity.ok(addcordinator);
	    }

	 @GetMapping("/getallcoordinator")
	 public ResponseEntity<List<Coordinator>> getAllCoordinators() {
	     List<Coordinator> coordinators = coordinatorServices.getAllCoordinators();
	     if (coordinators.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     return ResponseEntity.ok(coordinators);
	 }
	 
	  @GetMapping("/getcoordinator/{id}")
	    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable Integer id) {
	        Optional<Coordinator> coordinator = coordinatorServices.getCoordinatorById(id);
	        return coordinator.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	  
	  
	  @PutMapping("/editcoordinator/{id}")
	    public ResponseEntity<Coordinator> updateCoordinator(
	            @PathVariable Integer id,
	            @RequestBody Coordinator updatedCoordinator) {
	        Optional<Coordinator> existingCoordinator = coordinatorServices.getCoordinatorById(id);
	        if (existingCoordinator.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        // Update the fields as needed
	        Coordinator coordinatorToUpdate = existingCoordinator.get();
	        coordinatorToUpdate.setName(updatedCoordinator.getName());
	        coordinatorToUpdate.setEmpid(updatedCoordinator.getEmpid());
	        coordinatorToUpdate.setMobileno(updatedCoordinator.getMobileno());
	        coordinatorToUpdate.setEmailid(updatedCoordinator.getEmailid());

	        // Save the updated coordinator
	        Coordinator savedCoordinator = coordinatorServices.saveCoordinator(coordinatorToUpdate);
	        savedCoordinator.setMsg("Update Successfully");
	        return ResponseEntity.ok(savedCoordinator);
}
	  
	  @DeleteMapping("/delcoordinator/{id}")
	    public ResponseEntity<String> deleteCoordinator(@PathVariable Integer id) {
	        Optional<Coordinator> existingCoordinator = coordinatorServices.getCoordinatorById(id);
	        if (existingCoordinator.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        // Delete the coordinator
	      String msg=  coordinatorServices.deleteCoordinator(id);
	        return ResponseEntity.ok(msg);
	    }
	  
}
