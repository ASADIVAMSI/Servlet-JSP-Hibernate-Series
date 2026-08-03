package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signin")
public class SignInProcessServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("mail");
		String password = req.getParameter("pass");
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root", "root");
			dbStmt = dbConn.createStatement();
			
			String sqlQuery ="SELECT * FROM employee_personal WHERE email='"+email+"'AND login_password="+password;
			
		 dbRs = dbStmt.executeQuery(sqlQuery);
		 
		 if(dbRs.next()) {
			 String fname=dbRs.getString("first_name");
			 String lname=dbRs.getString("last_name");
			 
			 out.println("<h2>");
			 out.println("<font color='green'>");
			 out.println("Welcome "+fname+" "+lname+".");
			 out.println("</font>");
			 out.println("</h2>"); 
			 out.println("<a href='inbox'>Inbox</a><br>");
			 out.println("<a href='outbox'>Outbox</a><br>");
			 out.println("<a href='spam'>Spam</a>");
			 
			 HttpSession httpSession = req.getSession();
			 httpSession.setAttribute("USERNAME", fname);
			
		 }
		 
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
			
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			
			 out.println("<h2 style='color:red;'>Invalid Access</h2>");
		}finally {
			try {
				if(dbStmt !=null) {
					dbStmt.close();
				}
				if(dbConn !=null) {
					dbConn.close();
				}
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}

}
