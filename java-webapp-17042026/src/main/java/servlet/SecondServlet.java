package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body bgcolor = 'green'>");
		out.println("<h2>");
		out.println("<Welcome to SecondServlet.>");
		out.println("</h2>");
		out.println("<a href = 'first'>FirstServletLink</a><br>");
		out.println("<a href = 'third'>ThirdServletLink</a><br>");
		out.println("</body>");
		out.println("</html>");
		
	}
	

}
