package com.iritm.iritmservices.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iritm.iritmservices.Dto.CourseDetailsDto;
import com.iritm.iritmservices.Entity.CourseSchedule;
import com.iritm.iritmservices.Entity.Coursedetails;
import com.iritm.iritmservices.Service.CourseScheduleService;
import com.iritm.iritmservices.Service.CourseServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class CourseController {
	
	@Autowired  
	CourseServices services;  
	@Autowired  
	CourseScheduleService courseScheduleService;  
	
	@GetMapping("/hellow")
    public String msg(){
	  	return  "hi web service";
	  }
	
	
	@GetMapping("/getcourse")  
	private List<Coursedetails> getAllBooks()   
	{  
	return services.getCourseDetails();
	}  

	@PostMapping(value="/createcourse", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> handleFileUpload(@ModelAttribute CourseDetailsDto courseDetailsDto) throws IOException {
		
		courseDetailsDto.getCoursename();
		System.out.println("courseName "+courseDetailsDto);

		services.saveCourseDetails(courseDetailsDto);

		return ResponseEntity.ok("Files uploaded successfully!");
	}
	
	
	@PutMapping(value="/editcourse/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> editcourse( @PathVariable Long id,
            @RequestBody CourseDetailsDto courseDetailsDto) throws IOException {
		
		
		
		CourseDetailsDto existingcourse = (CourseDetailsDto) services.getCourseDetails();
	        if (existingcourse == null) {
	            return ResponseEntity.notFound().build();
	        }
	        existingcourse.setCoursename(courseDetailsDto.getCoursename());
	        existingcourse.setCoursecode(courseDetailsDto.getCoursecode());
	        existingcourse.setCoursedescription(courseDetailsDto.getCoursedescription());
	        existingcourse.setAdvertisement(courseDetailsDto.getAdvertisement());
	        existingcourse.setFile(courseDetailsDto.getFile());
	        existingcourse.setFilename(courseDetailsDto.getFilename());
	        services.saveCourseDetails(courseDetailsDto);

		    return ResponseEntity.ok("Update course successfully!");
	}
	
	 @GetMapping("/getcourse/{id}")
	    public ResponseEntity<Coursedetails> getCourseById(@PathVariable Long id) {
		 //Coursedetails schedule = services.getCourseById(id);
		 Coursedetails schedule=new Coursedetails();
	        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
	    }
	
	
	

    @PostMapping("/add-course-schedule")
    public CourseSchedule addCourseSchedule(@RequestBody CourseSchedule courseSchedule) {
    	CourseSchedule saveCourseSchedule= courseScheduleService.saveCourseSchedule(courseSchedule);
    	saveCourseSchedule.setMsg("Add Record Successfully");
        return saveCourseSchedule;
    }

    @GetMapping("/course-schedule/{id}")
    public ResponseEntity<CourseSchedule> getCourseScheduleById(@PathVariable Long id) {
        CourseSchedule schedule = courseScheduleService.getCourseScheduleById(id);
        return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/edit-course-schedule/{id}")
    public ResponseEntity<CourseSchedule> updateCourseSchedule(
            @PathVariable Long id,
            @RequestBody CourseSchedule updatedSchedule) {
        CourseSchedule existingSchedule = courseScheduleService.getCourseScheduleById(id);
        if (existingSchedule == null) {
            return ResponseEntity.notFound().build();
        }

       // Update the fields as needed
       // existingSchedule.setCourseCode(updatedSchedule.getCourseCode());
       // existingSchedule.setCourseName(updatedSchedule.getCourseName());
        existingSchedule.setStartDate(updatedSchedule.getStartDate());
        existingSchedule.setEndDate(updatedSchedule.getEndDate());
        existingSchedule.setCoordinatorId(updatedSchedule.getCoordinatorId());
        existingSchedule.setProfessorId(updatedSchedule.getProfessorId());

        // Save the updated course schedule
        CourseSchedule savedSchedule = courseScheduleService.saveCourseSchedule(existingSchedule);
        savedSchedule.setMsg("Update Record Successfully");
        return ResponseEntity.ok(savedSchedule);
    }
    
    
    @DeleteMapping("/delete-course-schedule/{id}")
    public ResponseEntity<String> deleteCourseSchedule(@PathVariable Long id) {
        CourseSchedule existingSchedule = courseScheduleService.getCourseScheduleById(id);
        if (existingSchedule == null) {
            return ResponseEntity.notFound().build();
        }

        // Delete the course schedule
       String msg= courseScheduleService.deleteCourseSchedule(id);
       
        return ResponseEntity.ok(msg);
    }

	
	
}
