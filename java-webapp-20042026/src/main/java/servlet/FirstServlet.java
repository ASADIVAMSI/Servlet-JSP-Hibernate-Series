package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
//@WebServlet(value = "/first", loadOnStartup = 2)
public class FirstServlet extends HttpServlet {
	public FirstServlet() {
		System.out.println("FirstServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("FirstServlet: init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("FirstServlet: destroy()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FirstServlet: service()");
		
							//MEDIA TYPE / MIME (MULTIPURPOSE INTERNET MAIL EXTENSION) TYPE
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2>");
		out.println("Welcome to FirstServlet.");
		out.println("</h2>");
	}
}