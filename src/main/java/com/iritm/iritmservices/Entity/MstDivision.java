package com.iritm.iritmservices.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mst_divisions")
public class MstDivision {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
   @Column(name = "zn_cd")
    private String ZN_CD;
   
   @Column(name = "div_nm")
   private String DIV_NM;
   
   @Column(name = "div_cd")
   private String DIV_CD;

public String getZN_CD() {
	return ZN_CD;
}

public void setZN_CD(String zN_CD) {
	ZN_CD = zN_CD;
}

public String getDIV_NM() {
	return DIV_NM;
}

public void setDIV_NM(String dIV_NM) {
	DIV_NM = dIV_NM;
}

public String getDIV_CD() {
	return DIV_CD;
}

public void setDIV_CD(String dIV_CD) {
	DIV_CD = dIV_CD;
}
   
   
   
   
}
