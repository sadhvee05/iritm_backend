package com.iritm.iritmservices.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;

@Entity
@Table(name = "coursedetails")
public class Coursedetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
	
	 @Column(name = "coursename")
	  private String courseName;
	 
     @Column(name = "coursecode")
    private String courseCode;

    @Column(name = "coursedescription")
    private String courseDescription; 

    @Column(name = "advertisement")
    private String advertisement;

    @Lob
    @Column(name = "file")
	private byte[] file;
    
    private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	


	


  
    
}
