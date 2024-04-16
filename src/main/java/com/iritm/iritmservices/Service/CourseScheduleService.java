package com.iritm.iritmservices.Service;

import java.util.List;

import com.iritm.iritmservices.Entity.CourseSchedule;

public interface CourseScheduleService {
	
	CourseSchedule saveCourseSchedule(CourseSchedule courseSchedule);
	CourseSchedule getCourseScheduleById(Long id);
	List< CourseSchedule> getCourseSchedule();
	 String deleteCourseSchedule(Long id);

}
