package demoproject.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demoproject.dao.UserDao;
import demoproject.dao.UserDaoImpl;
import demoproject.entities.User;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        System.out.println("\n User Name : " + username);
        System.out.println("\n Password : " + password);
        System.out.println("\n Role : " + role);

        // Authenticate the user based on their role
        try {
        	
			UserDao registerDao = new UserDaoImpl();
			
			User user = registerDao.authenticate(username, password, role);

			if (role.equals("admin")) {
				HttpSession session  = request.getSession();
			    session.setAttribute("user", user);
			    response.sendRedirect("course_list.jsp");
			} else if (role.equals("user")) {
				HttpSession session  = request.getSession();
			    session.setAttribute("user", user);
			    response.sendRedirect("user.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
    }
}
