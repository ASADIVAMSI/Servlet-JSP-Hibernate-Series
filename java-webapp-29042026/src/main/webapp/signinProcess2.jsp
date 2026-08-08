<%@page import="entity.Employee"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="entity.Employee" id="employee" scope="session"/>
	<jsp:setProperty name="employee" property="emailAddress" param="emadd"/>
	<jsp:setProperty name="employee" property="loginPassword" param="lpass"/>
	
	<%
	Connection dbConn = null;
	Statement dbStmt = null;
	ResultSet dbRs = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "roote");
		dbStmt = dbConn.createStatement();

		String sqlQuery = "SELECT employee_id, first_name, last_name, date_of_birth FROM employee_personal ";
		sqlQuery += "WHERE email_address='" + employee.getEmailAddress() + "' AND login_password='" + employee.getLoginPassword() + "'";

		dbRs = dbStmt.executeQuery(sqlQuery);
		if (dbRs.next()) {
	%>
			<jsp:setProperty name="employee" property="employeeId" value="<%= dbRs.getInt(1) %>"/>
			<jsp:setProperty name="employee" property="firstName" value="<%= dbRs.getString(2) %>"/>
			<jsp:setProperty name="employee" property="lastName" value="<%= dbRs.getString(3) %>"/>
			<jsp:setProperty name="employee" property="dateOfBirth" value="<%= dbRs.getString(4) %>"/>
			
			<h2>
			<font color="green"">
			Welcome <jsp:getProperty name="employee" property="firstName"/> 
			<jsp:getProperty name="employee" property="lastName"/>
			</font>
			</h2>
			<a href='inbox2.jsp'>Inbox</a><br>
			<a href='outbox.jsp'>Outbox</a><br>
			<a href='spam.jsp'>Spam</a>
	<%
		} else {
	%>
			<h2>
			<font color='red'>
			Invalid Access
			</font>
			</h2>
			<a href='signin-form.html'>Try Again</a>
	<%
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
	%>
</body>
</html>