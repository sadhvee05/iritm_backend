package com.iritm.iritmservices.Service;

import java.util.List;
import java.util.Optional;

import com.iritm.iritmservices.Entity.Faculty;



public interface FacultyServices {
	
	Faculty saveFaculty(Faculty professor);
	List<Faculty> getAllFaculty() ;
	Optional<Faculty> getFacultyById(int id) ;
	String deleteFaculty(int id);

}
