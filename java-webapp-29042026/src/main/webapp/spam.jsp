<%@page import="entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Employee employee = (Employee) session.getAttribute("EMPLOYEEDATA");
	%>
	
	<h2>
	<font color="green">
		Welcome <%= employee.getFirstName() %> <%= employee.getLastName() %> to Spam.
	</font>
	</h2>
</body>
</html>