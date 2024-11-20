package com.tap.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addStudent
 */

public class addStudent extends HttpServlet 
{
	private String INSERT_STUDENT = "insert into student(student_id,student_name,student_email,student_address,student_mobile,password) values (?,?,?,?,?,?)";
	private Connection con;
	private PreparedStatement pstmt;


	@Override
	public void init() throws ServletException {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			int student_id = Integer.parseInt(req.getParameter("student_id"));
			String student_name = req.getParameter("student_name");
			String student_email = req.getParameter("student_email");
			String student_address = req.getParameter("student_address");
			String student_mobile = req.getParameter("student_mobile");
			String password = req.getParameter("password");
			
;			pstmt = con.prepareStatement(INSERT_STUDENT);

			pstmt.setInt(1, student_id);
			pstmt.setString(2, student_name);
			pstmt.setString(3, student_email);
			pstmt.setString(4, student_address);
			pstmt.setString(5, student_mobile);
			pstmt.setString(6, password);
			
			int status = pstmt.executeUpdate();
			
			if(status == 0)
			{
				resp.sendRedirect("fail.jsp");
			}
			else
			{
				resp.sendRedirect("FetchAll");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}