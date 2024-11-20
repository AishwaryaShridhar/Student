package com.tap.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */

public class CheckServlet extends HttpServlet 
{
	private Connection con;
	String get_all_data = "select * from student where student_email=?";
	private PreparedStatement pstmt;
	private ResultSet res;
	private RequestDispatcher rd;
	@Override
	public void init() throws ServletException {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			
			pstmt = con.prepareStatement(get_all_data);
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
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				
				pstmt.setString(1, email);
				
				res = pstmt.executeQuery();
				
				if(res.next())
				{
					String student_name = res.getString("student_name");
					String student_email = res.getString("student_email");
					String student_address = res.getString("student_address");
					
					HttpSession session = req.getSession();
					
					session.setAttribute("student_name", student_name);
					session.setAttribute("student_email", student_email);
					session.setAttribute("student_address", student_address);
					
					rd = req.getRequestDispatcher("studentDetails.jsp");
					
					rd.forward(req, resp);
				}
				else
				{
					resp.sendRedirect("register.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}