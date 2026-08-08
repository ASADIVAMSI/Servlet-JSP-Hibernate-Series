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

@WebServlet("/calculatesgst")
public class CalculateSGST extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int principleAmount =Integer.parseInt(req.getParameter("amount"));
		
		double sGstAmount = principleAmount * 0.12;		
		
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("SGSTAMOUNT", sGstAmount);
		httpSession.setAttribute("PRINCIPLEAMOUNT", principleAmount);
		
        out.println("<h1>SGST calculated</h1>");
        out.println("<a href='calculatecgst'>Proceed</a>");	
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("calculatecgst");
        //dispatcher.forward(req, resp);
        dispatcher.include(req, resp);
	}
}