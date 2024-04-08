package com.iritm.iritmservices.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iritm.iritmservices.Entity.Coordinator;


public interface CoordinatorRepo extends CrudRepository<Coordinator, Integer>  {
	
	  List<Coordinator> findAllByEmpid(String empid);

}
