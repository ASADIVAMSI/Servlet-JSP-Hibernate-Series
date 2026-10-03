<!DOCTYPE html>

<%@page import="com.codegnan.app.javawebapp10062026.entity.Employee"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		Employee employee = (Employee) session.getAttribute("EMPLOYEE");
	%>

	<h2>
		<font color="green">
			Welcome <%= employee.getFirstName() %> <%= employee.getLastName() %>
		</font>
	</h2>
</body>
</html>