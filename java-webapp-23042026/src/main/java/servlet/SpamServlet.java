package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/spam")
public class SpamServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession httpSession = req.getSession();
		String userName = (String) httpSession.getAttribute("USERNAME");
		
		out.println("<h2>");
		out.println("<font color='green'>");
		out.println("Welcome " + userName +" to Spam page.");
		out.println("</font>");
		out.println("</h2>");
		out.println("<a href='inbox'>Inbox</a><br>");
		out.println("<a href='outbox'>Outbox</a><br>");
		out.println("<a href='spam'>Spam</a>");
	}
}