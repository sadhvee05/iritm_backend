package com.iritm.iritmservices.Repo;

import org.springframework.data.repository.CrudRepository;

import com.iritm.iritmservices.Entity.Registration;

public interface RegistrationRepo extends CrudRepository<Registration, Integer> {
	

}
