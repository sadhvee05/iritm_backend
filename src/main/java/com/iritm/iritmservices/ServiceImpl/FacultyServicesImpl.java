package com.iritm.iritmservices.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Entity.Faculty;
import com.iritm.iritmservices.Repo.FacultyRepo;
import com.iritm.iritmservices.Service.FacultyServices;

@Service
public class FacultyServicesImpl implements  FacultyServices  {

	@Autowired
    private FacultyRepo professorRepository;
 @Override
    public Faculty saveFaculty(Faculty professor) {
        return professorRepository.save(professor);
    }
 @Override
    public List<Faculty> getAllFaculty() {
        return (List<Faculty>) professorRepository.findAll();
    }
 
 @Override
    public Optional<Faculty> getFacultyById(int id) {
        return (Optional<Faculty>) professorRepository.findById(id);
    }

 public String deleteFaculty(int id) {
	 String msg="";
	 try {
		 professorRepository.deleteById(id);
        msg="Delete Record successfully";
	 }catch(Exception ex)
	 {
		 msg="Some Error, Please try again later";
	 }
        
		return msg;
    }

	
}
