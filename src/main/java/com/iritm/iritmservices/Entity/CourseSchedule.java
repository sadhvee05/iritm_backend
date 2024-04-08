package com.iritm.iritmservices.Entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_schedule")
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseId;
    private String courseCode;
    private String courseName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer coordinatorId;
    private Integer professorId;
    private String msg;

    
    public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public Integer getCoordinatorId() {
		return coordinatorId;
	}


	public void setCoordinatorId(Integer coordinatorId) {
		this.coordinatorId = coordinatorId;
	}


	public Integer getProfessorId() {
		return professorId;
	}


	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}


	public CourseSchedule() {
    }

    // Other constructors if needed

    // Getters and setters for all fields
    // ...

    // Additional methods or business logic if needed
}
