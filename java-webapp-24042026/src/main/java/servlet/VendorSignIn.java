package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/vendorsignin")
public class VendorSignIn extends  HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String emailAddress = req.getParameter("emadd");
		String loginPassword = req.getParameter("lpass");
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		ServletContext  ServletContext = getServletContext();
		String dbdriverClass = ServletContext.getInitParameter("DBDRIVERCLASS");
		String dbConnectionurl = ServletContext.getInitParameter("DBCONNECTIONURL");
		String dbUsername = ServletContext.getInitParameter("DBUSERNAME");
		String dbPassword = ServletContext.getInitParameter("DBPASSWORD");


		try {
			
			
			Class.forName(dbdriverClass);
			dbConn = DriverManager.getConnection(dbConnectionurl, dbUsername, dbPassword);
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT name FROM vendor_information ";
				  sqlQuery += "WHERE email_address ='" + emailAddress + "' AND login_password='" + loginPassword + "'";
			
			dbRs = dbStmt.executeQuery(sqlQuery);
			if (dbRs.next()) {
				String name = dbRs.getString(1);
							
				out.println("<h2>");
				out.println("<font color='green'>");
				out.println("Welcome " + name);
				out.println("</font>");
				out.println("</h2>");
				
			} else {
				out.println("<h2>");
				out.println("<font color='red'>");
				out.println("Invalid Access");
				out.println("</font>");
				out.println("</h2>");
				out.println("<a href='vendor-signin-form.html'>Try Again</a>");
			
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
