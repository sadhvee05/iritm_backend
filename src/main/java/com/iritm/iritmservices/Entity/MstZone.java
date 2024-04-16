package com.iritm.iritmservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_zones")
public class MstZone {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
   @Column(name = "zn_cd")
    private String ZN_CD;
   
   @Column(name = "zn_nm")
   private String ZN_NM;
   
   @Column(name = "type")
   private String type;

public String getZN_CD() {
	return ZN_CD;
}

public void setZN_CD(String zN_CD) {
	ZN_CD = zN_CD;
}

public String getZN_NM() {
	return ZN_NM;
}

public void setZN_NM(String zN_NM) {
	ZN_NM = zN_NM;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

}
