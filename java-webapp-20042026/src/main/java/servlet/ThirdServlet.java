package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
//@WebServlet(value = "/third", loadOnStartup = 1)
public class ThirdServlet extends HttpServlet {
	public ThirdServlet() {
		System.out.println("ThirdServlet()");
	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("ThirdServlet: init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("ThirdServlet: destroy()");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ThirdServlet: service()");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2>");
		out.println("Welcome to ThirdServlet.");
		out.println("</h2>");
	}
}