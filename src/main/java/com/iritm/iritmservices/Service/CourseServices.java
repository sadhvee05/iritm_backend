package com.iritm.iritmservices.Service;

import java.util.List;
import java.util.Optional;

import com.iritm.iritmservices.Dto.CourseDetailsDto;
import com.iritm.iritmservices.Entity.Coursedetails;


public interface CourseServices {
	List<Coursedetails> getCourseDetails() ;
	
	Coursedetails saveCourseDetails(CourseDetailsDto courseDetailsDto);
	Coursedetails saveCourseDetails1(CourseDetailsDto courseDetailsDto);
	
	 Optional<Coursedetails> getCourseById(Long id);
	
}
