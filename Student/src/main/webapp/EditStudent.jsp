<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.server.Student" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Details</title>
</head>
<body>
	<center>
		<h2>Edit Student Details</h2>
		
		<%
			int student_id = Integer.parseInt(request.getParameter("student_id"));
		    Student student = null; 
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
				PreparedStatement pstmt = con.prepareStatement("select * from student where student_id = ?");
				
				pstmt.setInt(1, student_id);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					student = new Student();
					student.setStudent_id(rs.getInt("student_id"));
					student.setStudent_name(rs.getString("student_name"));
					student.setStudent_email(rs.getString("student_email"));
					student.setStudent_address(rs.getString("student_address"));
					student.setStudent_mobile(rs.getString("student_mobile"));
					student.setPassword(rs.getString("password"));
				}
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		%>
		
		<% if(student != null) { %>
		<form action="UpdateStudentServlet" method="POST">
            <input type="hidden" name="student_id" value="<%= student.getStudent_id() %>">
            <table>
                <tr>
                    <td>Student Address:</td>
                    <td><input type="text" name="student_address" value="<%= student.getStudent_address() %>"></td>
                </tr>
                <tr>
                    <td>Student Mobile:</td>
                    <td><input type="text" name="student_mobile" value="<%= student.getStudent_mobile() %>"></td>
                </tr>
                <tr>
                    <td>Student Password:</td>
                    <td><input type="password" name="password" value="<%= student.getPassword() %>"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update Student"></td>
                </tr>
            </table>
        </form>
		<% } else { %>
		<p>Student not found</p>
		<% } %>
	</center>
</body>
</html>