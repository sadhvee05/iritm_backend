package com.iritm.iritmservices.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iritm.iritmservices.Entity.MstDivision;
import com.iritm.iritmservices.Entity.MstZone;

@Repository
public interface MstZoneRepo  extends CrudRepository<MstZone, String> {
	@Query(value = "SELECT * FROM mst_zones ", nativeQuery = true)
	   public List<MstZone>  getAllzone();
	@Query(value = "SELECT * FROM mst_zones WHERE type=? ", nativeQuery = true)
	   public List<MstZone>  getzoneByType(String type);
	
	
	
	
	
}
