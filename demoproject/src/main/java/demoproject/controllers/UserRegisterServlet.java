package demoproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoproject.dao.UserDao;
import demoproject.dao.UserDaoImpl;
import demoproject.entities.User;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("confirm_password");
        String role = request.getParameter("role");
        
        System.out.println("\n User Name : " + name);
        System.out.println("\n Email : " + email);
        System.out.println("\n Password : " + password);
        System.out.println("\n Confirm Password : " + cpassword);
        System.out.println("\n Role : " + role);
        
        User register = new User(name, email, password, cpassword, role);
        
        UserDao registerDao = new UserDaoImpl();
		
        try {
    			int result = registerDao.addDetails(register);
    			
    			System.out.println("\n Result : " + result);
    				
    			if(result > 0) {
    				response.sendRedirect("login.jsp?message=Details Added Successfully");
    			} else {
    				response.sendRedirect("register.jsp?message=Details can't be Added. Try again");
    			}	
    	} catch (Exception e) {
    			response.sendRedirect("register.jsp?message=Details can't be Added. Try again");
    			e.printStackTrace();
    		}
	}

}
