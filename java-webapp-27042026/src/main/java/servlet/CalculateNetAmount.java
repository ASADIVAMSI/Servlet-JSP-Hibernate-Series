package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calculatenetamount")
public class CalculateNetAmount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		HttpSession httpSession = req.getSession();
		int principleAmount = (Integer) httpSession.getAttribute("PRINCIPLEAMOUNT");
		double sGstAmount = (Double) httpSession.getAttribute("SGSTAMOUNT");
		double cGstAmount = (Double) httpSession.getAttribute("CGSTAMOUNT");
		double serviceTaxAmount = (Double) httpSession.getAttribute("SERVICETAXAMOUNT");

		double netAmount = principleAmount + sGstAmount + cGstAmount + serviceTaxAmount;

		out.println("<h1>Net Amount Payable (including taxes) is INR " + netAmount + "</h1>");
	}
}