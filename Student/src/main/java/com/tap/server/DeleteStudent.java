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
 * Servlet implementation class DeleteStudent
 */

public class DeleteStudent extends HttpServlet 
{
	private String delete_on_id = "delete from student where student_id = ?";
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
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try
			{
				int student_id = Integer.parseInt(req.getParameter("student_id"));
				
				pstmt = con.prepareStatement(delete_on_id);
				
				pstmt.setInt(1, student_id);
				
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