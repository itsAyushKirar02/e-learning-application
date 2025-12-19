<%@page import="demoproject.entities.User"%>
<%@page import="demoproject.utils.Utils"%>
<%@page import="java.util.List"%>
<%@page import="demoproject.dao.CourseDaoImpl"%>
<%@page import="demoproject.dao.CourseDao"%>
<%@page import="demoproject.entities.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>

<link href="css/style.css" type="text/css" rel="stylesheet">

<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
        background: url('https://png.pngtree.com/background/20210706/original/pngtree-luminous-blue-abstract-wavy-promote-its-album-cover-background-picture-image_92255.jpg') no-repeat center center fixed;
        background-size: cover;
    }
    h1 {
        color: #333;
        margin-bottom: 40px;
        font-size: 2.5em;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
    }
    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background-color: rgba(255, 255, 255, 0.9);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: left;
    }
    th {
        background-color: #007bff;
        color: white;
        font-weight: bold;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    caption {
        margin-bottom: 20px;
        font-size: 24px;
        letter-spacing: 1px;
        color: #007bff;
        text-decoration: underline;
        font-weight: bold;
    }
    a.blue-btn {
        background-color: #007bff;
        color: white;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        display: inline-block;
    }
    a.blue-btn:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
        box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
    }
    a#red-btn {
        background-color: #dc3545;
    }
    a#red-btn:hover {
        background-color: #c82333;
    }
    .center-btn {
        text-align: center;
        padding: 20px 0;
    }
    .logout-btn {
        position: absolute;
        bottom: 20px;
        right: 20px;
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        text-align:center;
        transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
   .logout-btn:hover {
        background-color: #0056b3;
        transform: translateY(-2px);
        box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
    }
</style>
<script>
     function confirmDeletion(course_id) {
    	 if (confirm("Are you Sure you want to Delete this Course")) {
    		 window.location.href="deletecourse?id=" + course_id
    		 
    	 }
    	 
     }
</script>

</head>
<body>
    <%
    
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    
    User user = (User)session.getAttribute("user");
    if(user==null) {
 	   response.sendRedirect("login.jsp?message=Login to continue");
    }
                CourseDao courseDao = new CourseDaoImpl();
                List<Course> courseList = courseDao.getAllCourses();
    %>
    
    <h1>Course Details</h1>
    
    <table>
        <caption>Course List</caption>  
        <tr>
            <th>Serial No.</th>
            <th>Course Name</th>
            <th>Course Instructor</th>
            <th>Course Duration</th>
            <th>Course Fees</th>
            <th>Course Description</th>
            <th>Course Image</th>
            <th>Action</th>
        </tr>
        
        <%
                
                                 
                                        int sNo=0;
                                        for(Course course : courseList) {
                %>
        <tr>
            <td><%= ++sNo %></td>
            <td><%= course.getName() %></td>
            <td><%= course.getInstructor() %></td>
            <td><%= course.getDuration() %></td>
            <td><%= course.getFees() %></td>
            <td><%= course.getDescription() %></td>
            <td><img src="data:image/jpg;base64, <%= Utils.displayImage(course.getCourseImage()) %>" style="width: 80px; height: 80px; border-radius: 8px;"/></td>
            <td>
                <a class="blue-btn" href="update_course.jsp?id=<%= course.getCourseId() %>">Update</a>
                <a class="blue-btn" id="red-btn" href="javascript:void(0);" onclick="confirmDeletion(<%= course.getCourseId() %>)">Delete</a>
                <a class="blue-btn" href="add_topic.jsp?id=<%= course.getCourseId() %>">Add Topic</a>
            </td>
        </tr> 
        <% } %>
        
        <tr>
            <td colspan="8" class="center-btn">
                <a class="blue-btn" href="add_course.jsp">Add Course</a>
            </td>
        </tr>
    </table>
    
     <a class="logout-btn" href="logout">Logout</a>
    
    <%@include file = "message.jsp" %>

</body>
</html>
