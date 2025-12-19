package demoproject.dao;

import java.util.List;

import demoproject.entities.Course;

public interface CourseDao {
	
	int addCourse(Course course) throws Exception;
	
	Course getCourse(int course_id) throws Exception;
	
	int updateCourse(Course course) throws Exception;
	
	int deleteCourse(int course_id) throws Exception;
	
	List<Course> getAllCourses() throws Exception;
		
}
