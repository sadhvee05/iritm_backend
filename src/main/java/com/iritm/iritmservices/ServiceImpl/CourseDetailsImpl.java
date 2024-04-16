package com.iritm.iritmservices.ServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Dto.CourseDetailsDto;
import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Entity.Coursedetails;
import com.iritm.iritmservices.Entity.Registration;
import com.iritm.iritmservices.Repo.CourseDetailsRepo;
import com.iritm.iritmservices.Repo.MstZoneRepo;
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
	
	
	public Coursedetails saveCourseDetails(CourseDetailsDto courseDetailsDto)   
	{  
		Coursedetails obj=new Coursedetails();
		obj.setCourseName(courseDetailsDto.getCoursename());
		obj.setCourseCode(courseDetailsDto.getCoursecode());
		obj.setCourseDescription(courseDetailsDto.getCoursedescription());
		obj.setAdvertisement(courseDetailsDto.getAdvertisement());
		obj.setFilename(courseDetailsDto.getFilename());
		//obj.setFile1(courseDetailsDto.getFile());
		
		System.out.println("objobjobjobj "+courseDetailsDto.getFile());
		
		//courseDetailsRepo.save(obj);
		
		
		return courseDetailsRepo.save(obj);
		
			
	}
	public Coursedetails saveCourseDetails1(CourseDetailsDto courseDetailsDto)   
	{  
		Coursedetails obj=new Coursedetails();
		obj.setCourseName(courseDetailsDto.getCoursename());
		obj.setCourseCode(courseDetailsDto.getCoursecode());
		obj.setCourseDescription(courseDetailsDto.getCoursedescription());
		obj.setAdvertisement(courseDetailsDto.getAdvertisement());
		obj.setFilename(courseDetailsDto.getFilename());
		try {
			obj.setFile(courseDetailsDto.getFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("objobjobjobj "+courseDetailsDto.getFile().getName());
		System.out.println("objobjobjobj "+courseDetailsDto.getFile().getOriginalFilename());
		System.out.println("objobjobjobj "+courseDetailsDto.getFile().getSize());
		System.out.println("objobjobjobj "+courseDetailsDto.getFile().getContentType());
		
		
		courseDetailsRepo.save(obj);
		Coursedetails ob=new Coursedetails();
		ob.setMsg("Success");
		return ob;
		
			
	}




	@Override
    public Optional<Coursedetails> getCourseById(Long id) {
        return (Optional<Coursedetails>) courseDetailsRepo.findById(id);
    }
	
	
	
	
	

	
	
}
