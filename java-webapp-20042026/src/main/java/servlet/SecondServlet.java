package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
//@WebServlet(value = "/second", loadOnStartup = 3)
public class SecondServlet extends HttpServlet {
	public SecondServlet() {
		System.out.println("SecondServlet()");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("SecondServlet: init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("SecondServlet: destroy()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet: service()");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2>");
		out.println("Welcome to SecondServlet.");
		out.println("</h2>");
	}
}