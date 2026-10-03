<%@page import="java.util.List"%>
<%@page import="com.codegnan.app.javaapp13052026practice.entity.Citizen"%>
<%@page import="com.codegnan.app.javaapp13052026practice.service.passportService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of Birth</th>
		</tr>
	<%
	passportService employeeService = new passportService();
		List<Citizen> employeesList = employeeService.getEmployeesList();
		for (Citizen employee :  employeesList) {
	%>
			<tr>
				<td><%= employee.getEmployeeId() %></td>
				<td><%= employee.getFirstName() %></td>
				<td><%= employee.getLastName() %></td>
				<td><%= employee.getDateOfBirth() %></td>
			</tr>
	<%		
		}
	%>
	
	</table>
</body>
</html>