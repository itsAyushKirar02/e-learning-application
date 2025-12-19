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

import demoproject.entities.Course;
import demoproject.dao.CourseDao;
import demoproject.dao.CourseDaoImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/addcourse")
public class AddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String instructor = request.getParameter("instructor");
        String duration = request.getParameter("duration");
        String fees = request.getParameter("fees");
        String description = request.getParameter("description");
        Part image = request.getPart("course_image");
        
        double time = Double.parseDouble(duration);
        double fee = Double.parseDouble(fees);
        InputStream cimage = image.getInputStream();

        Course course = new Course(name, instructor, time, fee, description, cimage);
    		
        try {
    			CourseDao courseDao = new CourseDaoImpl();
    			
    			int result = courseDao.addCourse(course);
    				
    			if(result > 0) {
    				response.sendRedirect("add_topic.jsp?message=Course Added Successfully");
    			} else {
    				response.sendRedirect("add_course.jsp?message=Course can't be Added. Try again");
    			}	
    	} catch (Exception e) {
    			response.sendRedirect("add_course.jsp?message=Course can't be Added. Try again");
    			e.printStackTrace();
    		}
    }
}

