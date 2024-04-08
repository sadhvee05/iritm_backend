package com.iritm.iritmservices.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registrationdetails")
public class Registration {
	 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
	
	 @Column(name = "coursename")
	  private String coursename;
	 
     @Column(name = "coursecode")
     private String coursecode;
     
     @Column(name = "employeetype")
     private String employeetype;
     
     @Column(name = "hrmsid")
     private String hrmsid;
     
     @Column(name = "name")
     private String name;
     
     @Column(name = "gender")
     private String gender;
	
     @Column(name = "dob")
     private LocalDate dob;
     
     @Column(name = "dateofappointment")
     private LocalDate dateofappointment;
     
     
     
     @Column(name = "grade")
     private String grade;
     

     @Column(name = "department")
     private String department;
	 
     
     @Column(name = "designationineng")
     private String designationineng;
     
     @Column(name = "designationinhindi")
     private String designationinhindi;
	
     @Column(name = "placeofposting")
     private String placeofposting;

     
     @Column(name = "zone")
     private String zone;
     
     
     @Column(name = "division")
     private String division;
     
     @Column(name = "contactnumber")
     private String contactnumber;
     
 	@Column(name = "whatsappno") 
 	private String whatsappno;
	

    @Column(name = "emailid")
	 private String emailid;
	
	
	  @Column(name = "arrivalmode") 
	  private String arrivalmode;
	 
	 @Column(name = "arrivalnumber") 
	 private String arrivalnumber;
	 
	
	 @Column(name = "arrivalscheduletime") 
	 private LocalDateTime  arrivalscheduletime;
	
	 
	 @Column(name = "arrivallocation")
	 private String arrivallocation;
	 
	  @Column(name = "departuremode") 
	  private String departuremode;
	  
	  @Column(name = "departurenumber") 
	  private String departurenumber;
	 
	 @Column(name = "departurescheduletime") 
	 private LocalDateTime departurescheduletime;
	 
	 @Column(name = "familydetails") 
	 private String familydetails;
	 
	 @Column(name = "noofmember") 
	 private String noofmember;
	 
	 @Column(name = "flag") 
	 private String flag;
	 
	 @Column(name = "empgroup")
     private String group;
	 
	 @Column(name = "userid")
     private String userid;
	 
	 @Column(name = "password")
     private String password;
	 
	 
	 @Column(name = "verificationcode")
     private String verificationcode;
	 
	 @Column(name = "enabled")
     private boolean  enabled;
	 
	 
	 
	 public String getVerificationcode() {
		return verificationcode;
	}



	public void setVerificationcode(String verificationcode) {
		this.verificationcode = verificationcode;
	}



	



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDeparturemode() {
		return departuremode;
	}

	

	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public void setDeparturemode(String departuremode) {
		this.departuremode = departuremode;
	}

	public String getFamilydetails() {
		return familydetails;
	}

	public void setFamilydetails(String familydetails) {
		this.familydetails = familydetails;
	}

	public String getNoofmember() {
		return noofmember;
	}

	public void setNoofmember(String noofmember) {
		this.noofmember = noofmember;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDeparturenumber() {
		return departurenumber;
	}

	public void setDeparturenumber(String departurenumber) {
		this.departurenumber = departurenumber;
	}

	public LocalDateTime getDeparturescheduletime() {
		return departurescheduletime;
	}

	public void setDeparturescheduletime(LocalDateTime departurescheduletime) {
		this.departurescheduletime = departurescheduletime;
	}

	public String getDeparturelocation() {
		return departurelocation;
	}

	public void setDeparturelocation(String departurelocation) {
		this.departurelocation = departurelocation;
	}

	@Column(name = "departurelocation") 
	 private String departurelocation;
	

	public String getWhatsappno() {
		return whatsappno;
	}

	public void setWhatsappno(String whatsappno) {
		this.whatsappno = whatsappno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getArrivalmode() {
		return arrivalmode;
	}

	public void setArrivalmode(String arrivalmode) {
		this.arrivalmode = arrivalmode;
	}

	public String getArrivalnumber() {
		return arrivalnumber;
	}

	public void setArrivalnumber(String arrivalnumber) {
		this.arrivalnumber = arrivalnumber;
	}

	public LocalDateTime getArrivalscheduletime() {
		return arrivalscheduletime;
	}

	public void setArrivalscheduletime(LocalDateTime arrivalscheduletime) {
		this.arrivalscheduletime = arrivalscheduletime;
	}

	public String getArrivallocation() {
		return arrivallocation;
	}

	public void setArrivallocation(String arrivallocation) {
		this.arrivallocation = arrivallocation;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignationineng() {
		return designationineng;
	}

	public void setDesignationineng(String designationineng) {
		this.designationineng = designationineng;
	}

	public String getDesignationinhindi() {
		return designationinhindi;
	}

	public void setDesignationinhindi(String designationinhindi) {
		this.designationinhindi = designationinhindi;
	}

	public String getPlaceofposting() {
		return placeofposting;
	}

	public void setPlaceofposting(String placeofposting) {
		this.placeofposting = placeofposting;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDateofappointment() {
		return dateofappointment;
	}

	public void setDateofappointment(LocalDate dateofappointment) {
		this.dateofappointment = dateofappointment;
	}

	public String getHrmsid() {
		return hrmsid;
	}

	public void setHrmsid(String hrmsid) {
		this.hrmsid = hrmsid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}
     


	
    
}
