package com.iritm.iritmservices.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Entity.CourseSchedule;
import com.iritm.iritmservices.Repo.CourseScheduleRepo;
import com.iritm.iritmservices.Service.CourseScheduleService;


@Service
public class CourseScheduleImpl implements CourseScheduleService {

	
	@Autowired
    private CourseScheduleRepo courseScheduleRepo;

    public CourseSchedule saveCourseSchedule(CourseSchedule courseSchedule) {
    	 return courseScheduleRepo.save(courseSchedule);
    }

    public CourseSchedule getCourseScheduleById(Long id) {
        return courseScheduleRepo.findById(id).orElse(null);
    }
	
    
     public  List< CourseSchedule> getCourseSchedule()
     {
    	 return (List<CourseSchedule>)  courseScheduleRepo.findAll();
     }
    
    
    public String deleteCourseSchedule(Long id) {
		 String msg="";
		 try {
			 courseScheduleRepo.deleteById(id);
	        msg="Delete Record successfully";
		 }catch(Exception ex)
		 {
			 msg="Some Error, Please try again later";
		 }
	        
			return msg;
	    }
    
    
	
}
