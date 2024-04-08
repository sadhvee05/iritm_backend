package com.iritm.iritmservices.ServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Dto.CourseDetailsDto;
import com.iritm.iritmservices.Entity.Coursedetails;
import com.iritm.iritmservices.Entity.Registration;
import com.iritm.iritmservices.Repo.CourseDetailsRepo;
import com.iritm.iritmservices.Service.CourseServices;


@Service
public class CourseDetailsImpl implements CourseServices {

	@Autowired
	private CourseDetailsRepo courseDetailsRepo;
	
	@Override
	public List<Coursedetails> getCourseDetails() {
		List<Coursedetails> list=new ArrayList<Coursedetails>();
	
		courseDetailsRepo.findAll().forEach(list1 -> list.add(list1));
		
		System.out.println(list.get(1).getCourseCode());
	    return list;
	}
	
	
	public Void saveCourseDetails(CourseDetailsDto courseDetailsDto)   
	{  
		Coursedetails obj=new Coursedetails();
		obj.setCourseName(courseDetailsDto.getCoursename());
		obj.setCourseCode(courseDetailsDto.getCoursecode());
		obj.setCourseDescription(courseDetailsDto.getCoursedescription());
		obj.setAdvertisement(courseDetailsDto.getAdvertisement());
		obj.setFilename(courseDetailsDto.getFilename());
		obj.setFile(courseDetailsDto.getFile());
		
		System.out.println("objobjobjobj "+courseDetailsDto.getFile());
		
		
		
		courseDetailsRepo.save(obj);
		return null;
		
			
	}




	
	
	
	
	
	

	
	
}
