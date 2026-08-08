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

@WebServlet("/calculatest")
public class CalculateServiceTax extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession httpSession = req.getSession();
		int principleAmount = (Integer) httpSession.getAttribute("PRINCIPLEAMOUNT");

		double serviceTaxAmount = principleAmount * 0.02;
		httpSession.setAttribute("SERVICETAXAMOUNT", serviceTaxAmount);

		out.println("<h1>Service Tax calculated</h1>");
		out.println("<a href='calculatenetamount'>Proceed</a>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("calculatenetamount");
        //dispatcher.forward(req, resp);
		dispatcher.include(req, resp);
	}
}