<!DOCTYPE html>
<%@page import="demoproject.utils.Utils"%>
<%@page import="demoproject.dao.CourseDaoImpl"%>
<%@page import="demoproject.dao.CourseDao"%>
<%@page import="demoproject.entities.Course"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Course</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('https://png.pngtree.com/thumb_back/fh260/background/20200729/pngtree-colorful-flow-background-with-fluid-form-image_372440.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: white;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        div {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        textarea,
        input[type="file"] {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        img {
            display: block;
            margin: 10px 0;
            width: 80px;
            height: 80px;
            border-radius: 8px;
        }
        .form-control {
            margin-bottom: 15px;
        }
    </style>
    <script>
        function loadFile(event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
            output.onload = function() {
                URL.revokeObjectURL(output.src);
            }
        }
    </script>
</head>
<body>

<%


    String id = request.getParameter("id");
    int idInt = Integer.parseInt(id);

    CourseDao courseDao = new CourseDaoImpl();
    Course course = courseDao.getCourse(idInt);
%>

    <form action="updatecourse" method="post" enctype="multipart/form-data">
        <h1>Update Course</h1>
        <div class="form-control">
            <label for="courseId">Course ID:</label>
            <input type="number" id="courseId" readonly value="<%= course.getCourseId() %>" name="courseId"/>
        </div>
        <div class="form-control">
            <label for="name">Course Name:</label>
            <input type="text" id="name" value="<%= course.getName() %>" name="name" placeholder="Enter New Course Name"/>
        </div>
        <div class="form-control">
            <label for="instructor">Instructor:</label>
            <input type="text" id="instructor" value="<%= course.getInstructor() %>" name="instructor" placeholder="Enter New Course Instructor"/>
        </div>
        <div class="form-control">
            <label for="duration">Duration:</label>
            <input type="number" id="duration" value="<%= course.getDuration() %>" name="duration" placeholder="Enter New Course Duration"/>
        </div>
        <div class="form-control">
            <label for="fees">Fees:</label>
            <input type="number" id="fees" value="<%= course.getFees() %>" name="fees" placeholder="Enter New Course Fees"/>
        </div>
        <div class="form-control">
            <label for="courseDescription">Description:</label>
            <textarea id="courseDescription" name="description" rows="5" placeholder="Enter New Course Description"><%= course.getDescription() %></textarea>
        </div>
        <div class="form-control">
            <img id="output" src="data:image/jpg;base64,<%= Utils.displayImage(course.getCourseImage()) %>" alt="Course Image"/>
            <label for="img">Change Image:</label>
            <input type="file" name="course_image" accept="image/*" onchange="loadFile(event)" id="img"/>
        </div>
        <div>
            <button type="submit">Update Course</button>
        </div>
    </form>
</body>
</html>
