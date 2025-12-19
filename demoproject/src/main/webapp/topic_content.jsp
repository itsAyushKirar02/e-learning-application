<%@page import="java.util.List"%>
<%@page import="demoproject.entities.Topic"%>
<%@page import="demoproject.dao.TopicDaoImpl"%>
<%@page import="demoproject.dao.TopicDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic Content</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }
    .container {
        max-width: 800px;
        margin: 40px auto;
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .topic-content {
        padding: 20px;
        font-size: 18px;
        line-height: 1.5;
    }
    .not-found {
        padding: 20px;
        font-size: 18px;
        line-height: 1.5;
        color: #666;
    }
    .pdf-container {
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
</style>
</head>
<body>

<div class="container">
    <h2>Topic Content</h2>
    <%
    String id = request.getParameter("topicId");
    int IdInt = Integer.parseInt(id);
    
    List<Topic> list = (List<Topic>)session.getAttribute("topicsList");

    Topic topic = null;
    for (Topic t : list) {
        if (t.getId() == IdInt) {
            topic = t;
            break;
        }
    }

    if (topic != null) {
    %>
    <div class="topic-content">
        <p><%= topic.getDescription() %></p>
    </div>
 
    <%
    } else {
    %>
    <div class="not-found">
        <p>Topic not found.</p>
    </div>
    <%
    }
    %>
</div>

</body>
</html>