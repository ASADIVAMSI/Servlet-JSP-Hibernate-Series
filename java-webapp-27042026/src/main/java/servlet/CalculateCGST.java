package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calculatecgst")
public class CalculateCGST extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		HttpSession httpSession = req.getSession();
		
		int principleAmount = (Integer) httpSession.getAttribute("PRINCIPLEAMOUNT");

		double cGstAmount = principleAmount * 0.18;
		httpSession.setAttribute("CGSTAMOUNT", cGstAmount);

		out.println("<h1>CGST calculated</h1>");
		out.println("<a href='calculatest'>Proceed</a>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("calculatest");
        //dispatcher.forward(req, resp);
		dispatcher.include(req, resp);
	}
}