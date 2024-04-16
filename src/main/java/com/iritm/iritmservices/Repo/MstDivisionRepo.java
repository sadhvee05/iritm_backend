package com.iritm.iritmservices.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.iritm.iritmservices.Entity.MstDivision;

@Repository
public interface MstDivisionRepo extends CrudRepository<MstDivision, String> {

	@Query(value = "SELECT * FROM mst_divisions WHERE zn_cd=? ", nativeQuery = true)
	   public List<MstDivision>  getdivisionByzncd(String type);
	
	
}
