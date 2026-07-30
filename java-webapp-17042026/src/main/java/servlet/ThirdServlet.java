package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body bgcolor = 'yellow'>");
		out.println("<h2>");
		out.println("<Welcome to FirstServlet.>");
		out.println("</h2>");
		out.println("<a href = 'second'>SecondServletLink</a><br>");
		out.println("<a href = 'first'>firstServletLink</a><br>");
		out.println("</body>");
		out.println("</html>");
	}
	

}
