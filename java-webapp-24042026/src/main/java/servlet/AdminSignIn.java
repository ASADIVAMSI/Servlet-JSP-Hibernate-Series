package servlet;

import java.io.IOException;

import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value ="/adminsignin",
			initParams = {
					@WebInitParam(name = "ADMINEMAIL", value ="admin@codegnan.com"),
					@WebInitParam(name = "ADMINPASS",value="admincodegnan")
			,})
public class AdminSignIn extends  HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String inputEmailAddress = req.getParameter("emadd");
		String inputLoginPassword = req.getParameter("lpass");
		
		ServletConfig servletConfig = getServletConfig();
		String adminEmailAddress = req.getParameter("ADMINEMAIL");
		String adminLoginPassword = req.getParameter("ADMINPASS");
		
		
			if ((adminEmailAddress).equals(inputEmailAddress) && (adminLoginPassword).equals( inputLoginPassword)) {
		
				out.println("<h2>");
				out.println("<font color='green'>");
				out.println("Welcome Admin");
				out.println("</font>");
				out.println("</h2>");
				
			} else {
				out.println("<h2>");
				out.println("<font color='red'>");
				out.println("Invalid Access");
				out.println("</font>");
				out.println("</h2>");
				out.println("<a href='customer-signin-form.html'>Try Again</a>");
			
			}
		
	}

}
