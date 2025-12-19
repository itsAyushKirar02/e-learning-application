package demoproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoproject.dao.CourseDao;
import demoproject.dao.CourseDaoImpl;

@WebServlet("/deletecourse")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	    String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		String message = "Course can't be Deleted. Please Try Again";
		
		try {
			CourseDao courseDao = new CourseDaoImpl();
			
			int result = courseDao.deleteCourse(idInt);
			
			if(result > 0) {
				message = "Course Deleted Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("course_list.jsp?message=" + message);

	}

}
