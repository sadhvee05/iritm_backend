package com.iritm.iritmservices.Service;

import java.util.List;
import java.util.Optional;

import com.iritm.iritmservices.Entity.Coordinator;

public interface CoordinatorServices {
	
	Coordinator saveCoordinator(Coordinator coordinator);
	List<Coordinator> getAllCoordinators() ;
	Optional<Coordinator> getCoordinatorById(Integer id) ;
	String deleteCoordinator(Integer id);

}
