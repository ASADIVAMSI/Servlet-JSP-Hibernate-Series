
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpProcessServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int employeeId = Integer.parseInt(req.getParameter("empid"));
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String dateOfBirth = req.getParameter("dob");
		String emailAddress = req.getParameter("emadd");
		String loginPassword = req.getParameter("lpass");
		
		Connection dbConn = null;
		Statement dbStmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();

			String sqlQuery = "INSERT INTO employee_personal VALUES(" + 
							  employeeId + ", '" + firstName + "', '" + lastName + "', '" + 
							  dateOfBirth + "', '" + emailAddress + "', '" + loginPassword + "')";
			
			int numOfRowsAffected = dbStmt.executeUpdate(sqlQuery);
			if (numOfRowsAffected != 0) {
				out.println("<h2>");
				out.println("<font color='green'>");
				out.println("Congratulations! You are successfully registered with us. Enjoy the services!");
				out.println("</font>");
				out.println("</h2>");
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			
			out.println("<h2>");
			out.println("<font color='red'>");
			out.println("Apologies! There seems to be a technical issue. Please try again later!");
			out.println("</font>");
			out.println("</h2>");
		} finally {
			try {
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