package demoproject.utils;

public class CmUtils {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_BASE = "jdbc:mysql://localhost:3306";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/Courses";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1234";
	
	public static final String ADD_COURSE = "INSERT INTO course (name, instructor, duration, fees, description, course_image "
			+ ") VALUES (?, ?, ?, ?, ?, ?)";
	
	public static final String UPDATE_COURSE = "UPDATE course SET name = ?, instructor = ?"
			+ ", duration = ?, fees = ?, description = ?, course_image = ? WHERE course_id = ?";
	
	public static final String DELETE_COURSE = "DELETE FROM course WHERE course_id = ?";
	
	public static final String GET_COURSE = "SELECT * FROM course WHERE course_id = ?";
	
	public static final String GET_ALL_COURSES = "SELECT * FROM course";
	
	public static final String ADD_TOPIC = "INSERT INTO topics (`course_id`, `title`, `description`, `order`) VALUES (?, ?, ?, ?)";
	
	public static final String UPDATE_TOPIC = "UPDATE topics SET title = ?, description = ?,"
			+ " order = ? WHERE id = ?";
	
	public static final String DELETE_TOPIC = "DELETE FROM topics WHERE id = ?";
	
	public static final String GET_TOPIC = "SELECT * FROM topics WHERE id = ?";
	
	public static final String GET_ALL_TOPICS = "SELECT * FROM topics";

	// SELECT title, id FROM topics WHERE course_id=10
	
	public static final String GET_COURSEWISE_TOPICS = "SELECT * FROM topics WHERE course_id=?";

	public static final String ADD_DETAILS = "INSERT INTO user (`username`, `email`, `password`, `confirmpassword`, `role`) VALUES (?, ?, ?, ?, ?)";
	
	public static final String UPDATE_DETAILS = "UPDATE user SET email = ?, password = ?,"
			+ " confirmpassword = ? WHERE username = ?";
	
	public static final String DELETE_DETAILS = "DELETE FROM user WHERE username = ?";
	
	public static final String GET_DETAILS = "SELECT * FROM user WHERE username = ?";
	
	
//	`username`, `email`, `password`, `confirm password`, `role`
	public static final String AUTHENTICATE = "SELECT * FROM user WHERE username =? AND password =? AND role =?";
	
	public static final String GET_ALL_DETAILS = "SELECT * FROM user";

	
	
	
	
	
	
	
	
	
}
