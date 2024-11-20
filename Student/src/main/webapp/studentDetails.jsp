<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<h1>Welcome <% out.println(session.getAttribute("student_name")); %> to the JSP page</h1>
	<h1>Your Email is: <% out.println(session.getAttribute("student_email")); %></h1>
	<h1>Your Address is: <% out.println(session.getAttribute("student_address")); %></h1>
</body>
</html>