package com.iritm.iritmservices.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iritm.iritmservices.Entity.MstDivision;
import com.iritm.iritmservices.Entity.MstZone;
import com.iritm.iritmservices.Repo.MstDivisionRepo;
import com.iritm.iritmservices.Repo.MstZoneRepo;
import com.iritm.iritmservices.Service.ZoneServices;

@Service
public class ZoneImpl implements  ZoneServices{
	@Autowired
	private MstZoneRepo mstZoneRepo ;
	@Autowired
	MstDivisionRepo mstDivisionRepo;
	
	@Override
	public List<MstZone> getzone() {
		List<MstZone> list=new ArrayList<MstZone>();
	
		list=mstZoneRepo.getAllzone();
		return list;
	}
	public List<MstZone> getzonebytype(String type) {
		List<MstZone> list=new ArrayList<MstZone>();
	    list=mstZoneRepo.getzoneByType(type);
		return list;
	}
	
	public List<MstDivision> getdivisionbytzncd(String zncd) {
		List<MstDivision> list=new ArrayList<MstDivision>();
	    list=mstDivisionRepo.getdivisionByzncd(zncd);
		return list;
	}
	
	

}
