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

@WebServlet("/coustomersignin")
public class CustomerSignIn extends  HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String emailAddress = req.getParameter("emadd");
		String loginPassword = req.getParameter("lpass");
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT employee_id, first_name, last_name FROM employee_personal ";
				  sqlQuery += "WHERE email ='" + emailAddress + "' AND login_password='" + loginPassword + "'";
			System.out.println("just for check");
			dbRs = dbStmt.executeQuery(sqlQuery);
			if (dbRs.next()) {
				
				String userName = dbRs.getString(2) + " " + dbRs.getString(3);
							
				out.println("<h2>");
				out.println("<font color='green'>");
				out.println("Welcome " + userName);
				out.println("</font>");
				out.println("</h2>");
				
			} else {
				out.println("<h2>");
				out.println("<font color='red'>");
				out.println("Invalid Access");
				out.println("</font>");
				out.println("</h2>");
				out.println("<a href='customer-signin-form.html'>Try Again</a>");
			
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}
				
				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}

}
