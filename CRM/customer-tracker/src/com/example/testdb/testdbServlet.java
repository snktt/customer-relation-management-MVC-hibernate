package com.example.testdb;

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class testdbServlet
 */
@WebServlet("/testdbServlet")
public class testdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user="springstudent";
	String pass= "springstudent";
	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	String driver = "com.mysql.cj.jdbc.Driver";
	try {
		PrintWriter out = response.getWriter();
		out.println("Connecting to database" + jdbcUrl);
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
		out.println("Successs!!");
		conn.close();
	}
	catch(Exception e){
	e.printStackTrace();
	throw new ServletException(e);
	}
	
	}

}
