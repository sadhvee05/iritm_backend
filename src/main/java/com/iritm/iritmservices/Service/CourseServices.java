package com.iritm.iritmservices.Service;

import java.util.List;

import com.iritm.iritmservices.Dto.CourseDetailsDto;
import com.iritm.iritmservices.Entity.Coursedetails;
import com.iritm.iritmservices.Entity.Registration;

public interface CourseServices {
	List<Coursedetails> getCourseDetails() ;
	
	Void saveCourseDetails(CourseDetailsDto courseDetailsDto);
	
}
