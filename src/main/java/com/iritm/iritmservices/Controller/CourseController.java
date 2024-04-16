package com.iritm.iritmservices.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.iritm.iritmservices.Dto.CourseScheuleResponce;
import com.iritm.iritmservices.Dto.RequestDto;
import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Entity.CourseSchedule;
import com.iritm.iritmservices.Entity.Coursedetails;
import com.iritm.iritmservices.Repo.CoordinatorRepo;
import com.iritm.iritmservices.Repo.CourseDetailsRepo;
import com.iritm.iritmservices.Repo.FacultyRepo;
import com.iritm.iritmservices.Service.CourseScheduleService;
import com.iritm.iritmservices.Service.CourseServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/Dashboard")
public class CourseController {
	@Autowired  
	FacultyRepo facultyRepo;
	@Autowired  
	CoordinatorRepo coordinatorRepo;  
	@Autowired  
	CourseDetailsRepo courseDetailsRepo;  
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
	
	
	@PutMapping(value="/editcourse", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Coursedetails> editcourse(@PathVariable Long id,
            @RequestBody CourseDetailsDto courseDetailsDto) throws IOException {
		
		 // Long id=requestDto.getId();
		
		Optional<Coursedetails> existingcourse =  services.getCourseById(id);
	        if (existingcourse == null) {
	            return ResponseEntity.notFound().build();
	        }
	     //   String courseName=courseDetailsDto.getCoursename();
	        Coursedetails coursedetails=existingcourse.get();
	        coursedetails.setCourseName(courseDetailsDto.getCoursename());
	        coursedetails.setCourseCode(courseDetailsDto.getCoursecode());
	        coursedetails.setCourseDescription(courseDetailsDto.getCoursedescription());
	        coursedetails.setAdvertisement(courseDetailsDto.getAdvertisement());
	   // coursedetails.setFile1(courseDetailsDto.getFile());
	        coursedetails.setFile1(courseDetailsDto.getFile1());
	        coursedetails.setFilename(courseDetailsDto.getFilename());
	       
	        Coursedetails savedata= services.saveCourseDetails(courseDetailsDto);
	        savedata.setMsg("Recard Update Successfully");
		    return ResponseEntity.ok(savedata);
		    
	}
	
	@PostMapping(value="/createcourse1", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> createcourse(@ModelAttribute CourseDetailsDto courseDetailsDto) throws IOException {
		
		courseDetailsDto.getCoursename();
		System.out.println("courseName "+courseDetailsDto);
		String filename=courseDetailsDto.getFile().getOriginalFilename();
		String contenttype=courseDetailsDto.getFile().getOriginalFilename();
	System.out.println(filename+" -----------filename");
	System.out.println(contenttype+" contenttype");
	
		services.saveCourseDetails1(courseDetailsDto);
            
		return ResponseEntity.ok("Files uploaded successfully!");
		//return ResponseEntity.ok("Files uploaded successfully!");
	}
	
	
	
	
	 @GetMapping("/getcoursewithid")
	    public ResponseEntity<Coursedetails> getCourseById(@RequestBody RequestDto requestDto) {
		 Long id=requestDto.getId();
		 Optional<Coursedetails> schedule = services.getCourseById(id);
		
	        return  schedule.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping("/add-course-schedule")
    public CourseSchedule addCourseSchedule(@RequestBody CourseSchedule courseSchedule) {
		 
		Optional<Coursedetails> coursedetails= services.getCourseById(Long.parseLong(courseSchedule.getCourseName()));
		coursedetails.get().getCourseCode();
		courseSchedule.setCourseName(coursedetails.get().getCourseName());
		courseSchedule.setCourseCode(coursedetails.get().getCourseCode());
		courseSchedule.setCourseId(Integer.toString(coursedetails.get().getId()));
		CourseSchedule saveCourseSchedule= courseScheduleService.saveCourseSchedule(courseSchedule);
    	saveCourseSchedule.setMsg("Course Schedule Successfully");
        return saveCourseSchedule;
    }

    @GetMapping("/course-schedule/{id}")
    public ResponseEntity<CourseScheuleResponce> getCourseScheduleById(@PathVariable Long id) {
    	
        CourseSchedule schedule = courseScheduleService.getCourseScheduleById(id);
        CourseScheuleResponce courseScheuleResponce=new CourseScheuleResponce();
        courseScheuleResponce.setCourseId(schedule.getId());
        courseScheuleResponce.setCourseName(schedule.getCourseName());
        courseScheuleResponce.setCourseCode(schedule.getCourseCode());
        courseScheuleResponce.setCourseId(Long.parseLong(schedule.getCourseId()));
        Optional<Coursedetails> courseId = services.getCourseById(courseScheuleResponce.getCourseId());
        courseScheuleResponce.setCourseDesc(courseId.get().getCourseDescription());
        courseScheuleResponce.setStartDate(schedule.getStartDate());
        courseScheuleResponce.setEndDate(schedule.getEndDate());
        courseScheuleResponce.setCoordinatorId(schedule.getCoordinatorId());
        String coid=schedule.getCoordinatorId();
        String list=coordinatorRepo.getcoordinatorname(coid);
        courseScheuleResponce.setCoordinatorName(list);
        String list1 = facultyRepo.getfacultyname(schedule.getProfessorId());
        courseScheuleResponce.setProfessorId(schedule.getProfessorId());
        courseScheuleResponce.setProfessorNmae(list1);
        return schedule != null ? ResponseEntity.ok(courseScheuleResponce) : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/edit-course-schedule/{id}")
    public ResponseEntity<CourseSchedule> updateCourseSchedule(
    		@PathVariable Long id,
            @RequestBody CourseSchedule updatedSchedule) {
    	//Long id=requestDto.getId();
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
    public ResponseEntity<CourseSchedule> deleteCourseSchedule(@PathVariable Long id) {
    	
    	  CourseSchedule existingSchedule = courseScheduleService.getCourseScheduleById(id);
        if (existingSchedule == null) {
            return ResponseEntity.notFound().build();
        }

        // Delete the course schedule
       String msg= courseScheduleService.deleteCourseSchedule(id);
       CourseSchedule csobj=new CourseSchedule();
       csobj.setMsg(msg);
        return ResponseEntity.ok(csobj);
    }

    @GetMapping("/getall-course-schedule")  
	private List<CourseScheuleResponce> getAllcourse()
	{  
    	List<CourseSchedule>	list =courseScheduleService.getCourseSchedule();
    	List<CourseScheuleResponce> listdata=new ArrayList<CourseScheuleResponce>(); 
    	if(list.size()>0) {
    	for(int i=0;i<=list.size()-1;i++)
    	{
    		CourseScheuleResponce courseScheuleResponce=new CourseScheuleResponce();
    		
    	     courseScheuleResponce.setCourseName(list.get(i).getCourseName());
    	     courseScheuleResponce.setCourseCode(list.get(i).getCourseCode());
    		//courseScheuleResponce.setCourseId(Long.parseLong(list.get(i).getCourseId()));
            Optional<Coursedetails> courseId = services.getCourseById(Long.parseLong(list.get(i).getCourseId()));
            courseScheuleResponce.setCourseDesc(courseId.get().getCourseDescription());
    		
            courseScheuleResponce.setStartDate(list.get(i).getStartDate());
            courseScheuleResponce.setEndDate(list.get(i).getEndDate());
            courseScheuleResponce.setCoordinatorId(list.get(i).getCoordinatorId());
             String coid=list.get(i).getCoordinatorId();
             String coorditorname=coordinatorRepo.getcoordinatorname(coid);
             courseScheuleResponce.setCoordinatorName(coorditorname);
             courseScheuleResponce.setProfessorId(list.get(i).getProfessorId());
             String facultyname = facultyRepo.getfacultyname(list.get(i).getProfessorId());
              courseScheuleResponce.setProfessorNmae(facultyname);
    		
            listdata.add(courseScheuleResponce);
    		
    	}
    	}
    	else 
    	{
    		listdata.get(0).setMsg("No Record Found!!");
    	}
	return listdata;
	}  
	
}
