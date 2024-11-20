package com.tap.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class FetchAll extends HttpServlet 
{
	private ArrayList<Student> slist = new ArrayList<Student>();
	String get_all = "select * from student";
	private Connection con;
	private Statement stmt;
	private ResultSet resultSet;
	private PrintWriter pw;
	
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
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(get_all);
//			pw = resp.getWriter();
			slist.clear();
			while(resultSet.next())
			{
				slist.add(new Student(resultSet.getInt("student_id"),
				resultSet.getString("student_name"),
				resultSet.getString("student_email"),
				resultSet.getString("student_address"),
				resultSet.getString("student_mobile"),
				resultSet.getString("password")));
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("slist", slist);
			
			resp.sendRedirect("showStudent.jsp");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}