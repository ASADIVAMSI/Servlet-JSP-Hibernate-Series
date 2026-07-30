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

@WebServlet("/employeeslist")
public class EmployeesListServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body bgcolor='lightyellow'>");
		out.println("<table border='1' width='100%'>");
		out.println("<tr>");
		out.println("<th>Employee ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Salary</th>");
		out.println("<th>Address</th>");
		out.println("<th>Date of Joining</th>");
		out.println("<th>Age</th>");
		out.println("</tr>");
		
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs49","root","root");
			dbStmt = dbConn.createStatement();
			
			String sqlQuery = "SELECT * FROM employee";
			System.out.println(sqlQuery);
			dbRs = dbStmt.executeQuery(sqlQuery);
			
			System.out.println(dbRs);
			
			while(dbRs.next()) {
				out.println("<tr>");
				out.println("<td>" + dbRs.getInt(1)+"</td>");
				out.println("<td>" + dbRs.getString(2)+"</td>");
				out.println("<td>" + dbRs.getInt(3)+"</td>");
				out.println("<td>" + dbRs.getString(4)+"</td>");
				out.println("<td>" + dbRs.getString(5)+"</td>");
				out.println("<td>" + dbRs.getInt(6)+"</td>");
				out.println("</tr>");
				
			}
		}catch(ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
		}finally {
			try {
				if(dbConn != null) {
					dbConn.close();
				}
				if(dbStmt != null) {
					dbStmt.close();
				}
			}catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
