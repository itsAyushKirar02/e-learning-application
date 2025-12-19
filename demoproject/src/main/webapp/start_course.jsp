<%@page import="demoproject.entities.Topic"%>
<%@page import="java.util.List"%>
<%@page import="demoproject.dao.TopicDaoImpl"%>
<%@page import="demoproject.dao.TopicDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start Course</title>
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
    .topic-list {
        list-style: none;
        padding: 0;
        margin: 0;
    }
    .topic-list li {
        margin-bottom: 10px;
    }
    .topic-list a {
        text-decoration: none;
        color: #337ab7;
    }
    .topic-list a:hover {
        color: #23527c;
    }
</style>
</head>
<body>

<div class="container">
    <h2>Course Topics</h2>
    <ul class="topic-list">
    <% 
    String id = request.getParameter("id");
    int idInt = Integer.parseInt(id);
    TopicDao topicdao = new TopicDaoImpl();
    List<Topic> topics = topicdao.getTopicsCourseWise(idInt);
    session.setAttribute("topicsList", topics);
    %>

    <% for(Topic topic : topics) { %>
        <li>
            <a href="topic_content.jsp?topicId=<%= topic.getId()%>"><%= topic.getTitle() %></a>
        </li>
    <% } %>
    </ul>
</div>

</body>
</html>