package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regserver") // Frontend connected to backend with help of action in form tag
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("namef");
		String Lastname = request.getParameter("namel");
		String email = request.getParameter("email1");
		String mob = request.getParameter("mobile");
		// int mob = request.getParameter("mobile");
		String Add = request.getParameter("Address");
		String gender1 = request.getParameter("gender");
		String DOB = request.getParameter("dob");
		String age1 = request.getParameter("age");
		String state1 = request.getParameter("state");
		String country1 = request.getParameter("country");
		String degree1 = request.getParameter("degree");
		String passyr = request.getParameter("passing_year");
		String pass1 = request.getParameter("pass");

//		System.out.println(firstname);     // print on console
//		System.out.println(Lastname);
//		System.out.println(email);
//		System.out.println(mob);
//		System.out.println(Add);
//		System.out.println(gender1);
//		System.out.println(DOB);
//		System.out.println(age1);
//		System.out.println(state1);
//		System.out.println(country1);
//		System.out.println(degree1);
//		System.out.println(passyr);
//		System.out.println(pass1);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "root");
			PreparedStatement ps = c.prepareStatement(
					"insert into register(fname,lname,emails,mobile,address,gender,dob1,ag,state,country,degree,passyear,password)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, firstname);
			ps.setString(2, Lastname);
			ps.setString(3, email);
			ps.setString(4, mob);
			ps.setString(5, Add);
			ps.setString(6, gender1);
			ps.setString(7, DOB);
			ps.setString(8, age1);
			ps.setString(9, state1);
			ps.setString(10, country1);
			ps.setString(11, degree1);
			ps.setString(12, passyr);
			ps.setString(13, pass1);

			ps.executeUpdate();
			System.out.println("Data is inserted sucessfully");
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.print("Data is inserted sucessfully....!!");

//		PrintWriter out = response.getWriter();     // print on web-browser
//	
//		out.print("<h1 style='color:blue'>"+firstname+"</h1>");
//		out.print(email);																							
//		out.print(pass1);

	}

}
