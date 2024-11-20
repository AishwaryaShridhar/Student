package com.tap.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentServlet
 */

public class UpdateStudentServlet extends HttpServlet 
{
	private String modify_student = "update student set student_address = ?, student_mobile = ?, password = ? where student_id = ?";
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
				String student_address = req.getParameter("student_address");
				String student_mobile = req.getParameter("student_mobile");
				String password = req.getParameter("password");
				
				pstmt = con.prepareStatement(modify_student);
				
				pstmt.setString(1, student_address);
				pstmt.setString(2, student_mobile);
				pstmt.setString(3, password);
				pstmt.setInt(4, student_id);
				
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