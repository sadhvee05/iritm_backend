package com.iritm.iritmservices.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "faculty")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String fname;
    private String fempid;
    private String fmobileno;
    private String femailid;
    private String fmsg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFempid() {
		return fempid;
	}
	public void setFempid(String fempid) {
		this.fempid = fempid;
	}
	public String getFmobileno() {
		return fmobileno;
	}
	public void setFmobileno(String fmobileno) {
		this.fmobileno = fmobileno;
	}
	public String getFemailid() {
		return femailid;
	}
	public void setFemailid(String femailid) {
		this.femailid = femailid;
	}
	public String getFmsg() {
		return fmsg;
	}
	public void setFmsg(String fmsg) {
		this.fmsg = fmsg;
	}
    
    

}
