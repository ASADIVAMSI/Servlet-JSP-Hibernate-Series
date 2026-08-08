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
	<%
	String emailAddress = request.getParameter("emadd");
	String loginPassword = request.getParameter("lpass");

	Connection dbConn = null;
	Statement dbStmt = null;
	ResultSet dbRs = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "root");
		dbStmt = dbConn.createStatement();

		String sqlQuery = "SELECT employee_id, first_name, last_name, date_of_birth FROM employee_personal ";
		sqlQuery += "WHERE email_address='" + emailAddress + "' AND login_password='" + loginPassword + "'";

		dbRs = dbStmt.executeQuery(sqlQuery);
		if (dbRs.next()) {
			String userName = dbRs.getString(2) + " " + dbRs.getString(3);
	%>
			<h2>
			<font color="green"">
			Welcome <%= userName %>
			</font>
			</h2>
			<a href="inbox">Inbox</a><br>
			<a href="outbox">Outbox</a><br>
			<a href="spam">Spam</a>
	<%
			session.setAttribute("USERNAME", userName);
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

<%--

| Tag                 | Name        | Purpose                   |
| ------------------- | ----------- | ------------------------- |
| `<%! ... %>`        | Declaration | Declare variables/methods |
| `<% ... %>`         | Scriptlet   | Write Java code           |
| `<%= ... %>`        | Expression  | Print value               |
| `<%@ ... %>`        | Directive   | Give JSP instructions     |
| `<%-- ... `     | JSP Comment | JSP-only comment          |
| `<jsp:include>`     | Action      | Include resource          |
| `<jsp:forward>`     | Action      | Forward request           |
| `<jsp:useBean>`     | Action      | Work with JavaBean        |
| `<%@ taglib ... %>` | Taglib      | Use JSTL/custom tags      |


--%>