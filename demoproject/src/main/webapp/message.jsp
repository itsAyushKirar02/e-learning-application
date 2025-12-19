<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <%--  <h2>Message</h2>
    <p>${Message}</p>
    <a href="upload_pdf.jsp">Upload another file</a> --%>

<p>
    <%
      String message = request.getParameter("message");
      if(message != null) {
         out.print(message);
      }
    %>
</p>   


</body>
</html>