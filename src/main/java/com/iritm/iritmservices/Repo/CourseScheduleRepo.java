package com.iritm.iritmservices.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.iritm.iritmservices.Entity.CourseSchedule;
import com.iritm.iritmservices.Entity.MstZone;


public interface CourseScheduleRepo extends CrudRepository<CourseSchedule, Long> {
	
	@Query(value = "SELECT courseName From course_schedule Where course_code=? ", nativeQuery = true)
	   public List<CourseSchedule>  getCourseNameWBycourseCode(String coursecode);

}
