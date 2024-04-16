package com.iritm.iritmservices.Dto;

import java.time.LocalDateTime;

public class CourseScheuleResponce {
	
	    private Long courseId;
	    private String courseCode;
	    private String courseName;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
	    private String coordinatorName;
	    private String professorNmae;
	    private String coordinatorId;
	    private String professorId;
	    private String courseDesc;
	    private String msg;
	
		public Long getCourseId() {
			return courseId;
		}
		public void setCourseId(Long courseId) {
			this.courseId = courseId;
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
		public String getCoordinatorName() {
			return coordinatorName;
		}
		public void setCoordinatorName(String coordinatorName) {
			this.coordinatorName = coordinatorName;
		}
		public String getProfessorNmae() {
			return professorNmae;
		}
		public void setProfessorNmae(String professorNmae) {
			this.professorNmae = professorNmae;
		}
		
		public String getCoordinatorId() {
			return coordinatorId;
		}
		public void setCoordinatorId(String coordinatorId) {
			this.coordinatorId = coordinatorId;
		}
		public String getProfessorId() {
			return professorId;
		}
		public void setProfessorId(String professorId) {
			this.professorId = professorId;
		}
		public String getCourseDesc() {
			return courseDesc;
		}
		public void setCourseDesc(String courseDesc) {
			this.courseDesc = courseDesc;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		


}
