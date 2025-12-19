package demoproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoproject.dao.TopicDao;
import demoproject.dao.TopicDaoImpl;
import demoproject.entities.Topic;

@WebServlet("/startTopic")
public class StartTopicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
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

        @SuppressWarnings("unused")
		Topic topic = new Topic(cId, title, description, oder);
        
        try {
            TopicDao topicDao = new TopicDaoImpl();
            
            List<Topic> result = topicDao.getTopicsCourseWise(cId);
            
            if(!result.isEmpty()) {
                response.sendRedirect("intro.jsp?message=Topic Displayed Successfully");
            } else {
                response.sendRedirect("add_topic.jsp?id="+cId+"&message=Topic can't be Displayed. Try again");
            }    
        } catch (Exception e) {
            response.sendRedirect("add_topic.jsp?id="+cId+"&message=Topic can't be Displayed. Try again");
            e.printStackTrace();
        }
    }
}