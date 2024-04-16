package com.iritm.iritmservices.Service;

import java.util.List;

import com.iritm.iritmservices.Entity.MstDivision;
import com.iritm.iritmservices.Entity.MstZone;

public interface ZoneServices {
	 List<MstZone> getzone();
	 List<MstZone> getzonebytype(String type);
	 List<MstDivision> getdivisionbytzncd(String zncd);
}
