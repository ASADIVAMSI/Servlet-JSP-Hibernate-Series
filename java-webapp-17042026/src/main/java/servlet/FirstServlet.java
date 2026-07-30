package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body bgcolor='red'>");
		out.println("<h2> Welcome to First servlet.</h2>");
		
		//ABSOLUTE URL
		//out.println("<a href='http://localhost:8080/javawebapp17042026/second'>Visit Second Servlet</a><br>");
		//out.println("<a href='http://localhost:8080/javawebapp17042026/third'>Visit Third Servlet</a><br>");
		
		//RELATIVE URL
		out.println("<a href='second'>Visit Second Servlet</a><br>");
		out.println("<a href='third'>Visit Third Servlet</a><br>");
		out.println("<a href='index.html'>HOME</a>");
		
		//out.println("<a href='http://192.168.1.16:8080/javawebapp16042026/hello'>Visit Rahul's Servlet from Rahul's Web Application.</a>");
		out.println("<body>");
		out.println("</html>");
	}

}
