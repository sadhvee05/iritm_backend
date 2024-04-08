package com.iritm.iritmservices.Service;

import com.iritm.iritmservices.Entity.CourseSchedule;

public interface CourseScheduleService {
	
	CourseSchedule saveCourseSchedule(CourseSchedule courseSchedule);
	CourseSchedule getCourseScheduleById(Long id);
	 String deleteCourseSchedule(Long id);

}
