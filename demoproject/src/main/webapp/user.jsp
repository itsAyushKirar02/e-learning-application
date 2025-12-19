<%@page import="demoproject.entities.User"%>
<%@page import="demoproject.utils.Utils"%>
<%@page import="demoproject.entities.Course"%>
<%@page import="java.util.List"%>
<%@page import="demoproject.dao.CourseDaoImpl"%>
<%@page import="demoproject.dao.CourseDao"%>
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
       .course-card {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            width: 280px;
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            text-align: center;
            margin: 20px;
        }
       .course-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }
       .course-image {
            width: 100%;
            height: 180px;
            object-fit: cover;
            border-radius: 12px 12px 0 0;
        }
       .course-content {
            padding: 15px;
        }
       .course-content h2 {
            margin: 0 0 10px;
            font-size: 1.5em;
            color: #333;
        }
       .course-content p {
            margin: 5px 0;
            color: #666;
        }
       .start-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: block;
            margin: 15px auto 0;
            text-align: center;
            transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
       .start-btn:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
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
            font-size:16px;
            text-align:center;
            transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
       .logout-btn:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
        }
        .course-cards-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 20px;
        }
        @keyframes blink {
        0% { opacity: 1; }
        50% { opacity: 0; }
        100% { opacity: 1; }
    }

    .blinking-text {
        animation: blink 1s infinite;
        color: red; /* You can change the color as per your requirement */
    }
    </style>
</head>
<body>
   <h1 class="blinking-text">Welcome to E Learning Platform</h1>
    <h2>Course Details</h2>
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
    <div class="course-cards-container">
        <%
        
                 for(Course course : courseList) {
        %>
            <div class="course-card">
                <img src="data:image/jpg;base64, <%= Utils.displayImage(course.getCourseImage()) %>" alt="Course Image" class="course-image">
                <div class="course-content">
                    <h2><%= course.getName() %></h2>
                    <p>Instructor: <%= course.getInstructor() %></p>
                    <p>Duration: <%= course.getDuration() %> hours</p>
                    <p>Fees: Rs <%= course.getFees() %></p>
                    <a class="start-btn" href="start_course.jsp?id=<%= course.getCourseId() %>">Start Course</a>
                </div>
            </div>
        <% } %>
    </div>
    <a class="logout-btn" href="logout">Logout</a>
</body>
</html>