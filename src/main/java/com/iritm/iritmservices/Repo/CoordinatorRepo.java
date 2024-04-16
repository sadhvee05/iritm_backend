package com.iritm.iritmservices.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.iritm.iritmservices.Entity.Coordinator;



public interface CoordinatorRepo extends CrudRepository<Coordinator, Integer>  {
	
	@Query(value = "SELECT name FROM coordinator Where empid=?", nativeQuery = true)
	String getcoordinatorname(String empid);
	  
	  
	  Optional<Coordinator>  findById(int id );

}
