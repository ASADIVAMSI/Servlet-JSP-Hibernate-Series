<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int employeeId = Integer.parseInt(request.getParameter("empid"));
	String firstName = request.getParameter("fname");
	String lastName = request.getParameter("lname");
	String dateOfBirth = request.getParameter("dob");
	String emailAddress = request.getParameter("emadd");
	String loginPassword = request.getParameter("lpass");

	Connection dbConn = null;
	Statement dbStmt = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "roote");
		dbStmt = dbConn.createStatement();

		String sqlQuery = "INSERT INTO employee_personal VALUES(";
		sqlQuery += employeeId;
		sqlQuery += ", '" + firstName + "'";
		sqlQuery += ", '" + lastName + "'";
		sqlQuery += ", '" + dateOfBirth + "'";
		sqlQuery += ", '" + emailAddress + "'";
		sqlQuery += ", '" + loginPassword + "')";

		int numOfRowsAffected = dbStmt.executeUpdate(sqlQuery);
		if (numOfRowsAffected != 0) {
	%>
			<h2>
				<font color="green">Sign Up Successful.</font>
			</h2>
			<a href="signin-form.html">Sign In</a>
	<%
		}
	} catch (ClassNotFoundException cnfEx) {
		cnfEx.printStackTrace();
	} catch (SQLException sqlEx) {
		sqlEx.printStackTrace();
	%>
			<h2>
				<font color='red'> 
					Problem occurred! Please try again after	sometime.
				</font>
			</h2>
			<a href='index.html'>Home</a>
	<%
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
	%>
</body>
</html>