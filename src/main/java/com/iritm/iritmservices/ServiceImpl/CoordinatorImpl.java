package com.iritm.iritmservices.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Entity.Coordinator;
import com.iritm.iritmservices.Repo.CoordinatorRepo;
import com.iritm.iritmservices.Service.CoordinatorServices;



@Service
public class CoordinatorImpl implements CoordinatorServices {
	
	
	 @Autowired
	    private CoordinatorRepo coordinatorRepository;
	 @Override
	    public Coordinator saveCoordinator(Coordinator coordinator) {
	        return coordinatorRepository.save(coordinator);
	    }
	 @Override
	    public List<Coordinator> getAllCoordinators() {
	        return (List<Coordinator>) coordinatorRepository.findAll();
	    }
	 
	 @Override
	    public Optional<Coordinator> getCoordinatorById(Integer id) {
	        return (Optional<Coordinator>) coordinatorRepository.findById(id);
	    }

	 public String deleteCoordinator(Integer id) {
		 String msg="";
		 try {
	        coordinatorRepository.deleteById(id);
	        msg="Delete Record successfully";
		 }catch(Exception ex)
		 {
			 msg="Some Error, Please try again later";
		 }
	        
			return msg;
	    }
	
}
