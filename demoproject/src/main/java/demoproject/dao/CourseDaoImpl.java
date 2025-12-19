package demoproject.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import demoproject.entities.Course;
import demoproject.utils.CmUtils;

public class CourseDaoImpl implements CourseDao {
	
	Connection getConnection() throws Exception {
		Class.forName(CmUtils.DRIVER);
		
		Connection con = DriverManager.getConnection(CmUtils.DB_URL, CmUtils.USERNAME, CmUtils.PASSWORD);
		return con;
	}

	@Override
	public int addCourse(Course course) throws Exception {
		   
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.ADD_COURSE);
        
        pStmt.setString(1, course.getName());
        System.out.println(course.getName());
        
        pStmt.setString(2, course.getInstructor());
        System.out.println(course.getInstructor());
        
        pStmt.setDouble(3, course.getDuration());
        System.out.println(course.getDuration());
        
        pStmt.setDouble(4, course.getFees());
        System.out.println(course.getFees());
        
        pStmt.setString(5, course.getDescription());
        System.out.println(course.getDescription());
        
        pStmt.setBlob(6, course.getCourseImage());
        System.out.println(course.getCourseImage());
  
        return pStmt.executeUpdate();
	}

//	 @Override
	 public Course getCourse(int courseId) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(CmUtils.GET_COURSE); 
        pStmt.setInt(1, courseId);
		
		ResultSet rSet =  pStmt.executeQuery();
		
		Course course = null;
		
		if(rSet.next()) {
			int id = rSet.getInt("course_id");
			String name = rSet.getString("name");
			String instructor = rSet.getString("instructor");
			double duration = rSet.getDouble("duration");
			double fees = rSet.getDouble("fees");
			String description = rSet.getString("description");
			Blob cifileBlob = rSet.getBlob("course_image");
			InputStream course_image = cifileBlob.getBinaryStream();
			
			course = new Course(id, name, instructor, duration, fees, description, course_image); 
		}
		 return course;
	} 

	@Override
	public int updateCourse(Course course) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.UPDATE_COURSE);
		
		pStmt.setString(1, course.getName());
		pStmt.setString(2, course.getInstructor());
		pStmt.setDouble(3, course.getDuration());
		pStmt.setDouble(4, course.getFees());
		pStmt.setString(5, course.getDescription());
		pStmt.setBlob(6, course.getCourseImage());
		pStmt.setInt(7,course.getCourseId());
		
		return pStmt.executeUpdate();
	}

	@Override
	public int deleteCourse(int courseId) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.DELETE_COURSE);
		
		pStmt.setInt(1, courseId);

		return pStmt.executeUpdate();
	}
	
	@Override
	public List<Course> getAllCourses() throws Exception {
		
        Connection con = getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rSet = stmt.executeQuery(CmUtils.GET_ALL_COURSES);
		
		List<Course> courses = new ArrayList<Course>();
		
		while(rSet.next()) {
			int id = rSet.getInt("course_id");
			String name = rSet.getString("name");
		    String instructor = rSet.getString("instructor");
			double duration = rSet.getDouble("duration");
			double fees = rSet.getDouble("fees");
			String description = rSet.getString("description");
			Blob cifileBlob = rSet.getBlob("course_image");
			InputStream course_image = cifileBlob.getBinaryStream();
			
			courses.add(new Course(id, name, instructor, duration, fees, description, course_image));
		}
		return courses;
	}
}
