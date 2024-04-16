package com.iritm.iritmservices.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iritm.iritmservices.Entity.Faculty;

public interface FacultyRepo extends CrudRepository<Faculty, Integer> {
	@Query(value = "SELECT fname FROM faculty Where fempid=?", nativeQuery = true)
	String getfacultyname(String empid);

}

