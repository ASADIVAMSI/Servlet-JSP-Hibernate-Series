package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/processinput")
public class InputProcessingServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String mobileNumber = req.getParameter("mobnum");
		String emailAddress = req.getParameter("emadd");
		String loginPassword = req.getParameter("pass");
		String gender = req.getParameter("gen");
		String[] qualifications = req.getParameterValues("qual");
		String country = req.getParameter("cntr");
		String address = req.getParameter("addr");
		
		out.println("First Name: " + firstName);
		out.println("<br>Last Name: " + lastName);
		out.println("<br>Mobile Number: " + mobileNumber);
		out.println("<br>Email Address: " + emailAddress);
		out.println("<br>Login Password: " + loginPassword);
		out.println("<br>Gender: " + gender);
		
		
		for (String qual : qualifications) {
			out.println("<br>Qualification: " + qual);
		}
		 
		out.println("<br>Country: " + country);
		out.println("<br>Address: " + address);
	}
}	