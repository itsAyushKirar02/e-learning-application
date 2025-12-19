package demoproject.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoproject.dao.TopicDao;
import demoproject.dao.TopicDaoImpl;
import demoproject.entities.Topic;

@WebServlet("/addtopic")
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        String cid = request.getParameter("course_id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String order = request.getParameter("order");
 
        System.out.println("\n Course Id : " + cid);
        System.out.println("\n Title : " + title);
        System.out.println("\n Description : " + description);
        System.out.println("\n Order : " + order);
        
        int cId = Integer.parseInt(cid);
        int oder = Integer.parseInt(order);

        Topic topic = new Topic(cId, title, description, oder);
    		
        try {
    			TopicDao topicDao = new TopicDaoImpl();
    			
    			int result = topicDao.addTopic(topic);
    				
    			if(result > 0) {
    				response.sendRedirect("course_list.jsp?message=Topic Added Successfully");
    			} else {
    				response.sendRedirect("add_topic.jsp?message=Topic can't be Added. Try again");
    			}	
    	} catch (Exception e) {
    			response.sendRedirect("add_topic.jsp?message=Topic can't be Added. Try again");
    			e.printStackTrace();
    		}
	}


/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
