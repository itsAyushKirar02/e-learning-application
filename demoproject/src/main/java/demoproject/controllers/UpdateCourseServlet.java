package demoproject.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import demoproject.dao.CourseDao;
import demoproject.dao.CourseDaoImpl;
import demoproject.entities.Course;

@MultipartConfig
@WebServlet("/updatecourse")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		String id = request.getParameter("courseId");
		String name = request.getParameter("name");
		String instructor = request.getParameter("instructor");
		String duration = request.getParameter("duration");
		String fees = request.getParameter("fees");
		String description = request.getParameter("description");
		Part imagepart = request.getPart("course_image");
		
		System.out.println("\n Course Name : " + name);
		System.out.println("\n Course Instructor : " + instructor);
		System.out.println("\n Course Duration : " + duration);
		System.out.println("\n Course Fees : " + fees);
		System.out.println("\n Course Description : " + description);

        double time = Double.parseDouble(duration);
        double fee = Double.parseDouble(fees);
		InputStream courseimage = imagepart.getInputStream();
		int idInt = Integer.parseInt(id);
		
		Course course = new Course(idInt, name, instructor, time, fee, description, courseimage);
		
		try {
			CourseDao courseDao = new CourseDaoImpl();
			
			int result = courseDao.updateCourse(course);
			
			System.out.println(result);
				
			if(result > 0) {
				response.sendRedirect("course_list.jsp?message=Course Updated Successfully");
			} else {
				response.sendRedirect("update_course.jsp?id="+idInt+"&message=Course can't be Updated. Try again");
			}	
		} catch (Exception e) {
			System.out.println("exception");
			response.sendRedirect("update_course.jsp?id="+idInt+"&message=Course can't be Updated. Try again");
			e.printStackTrace();
		}

	}

}
