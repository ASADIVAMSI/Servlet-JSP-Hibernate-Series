<%@page import="com.codegnan.app.javaapp13052026practice.entity.Passport"%>
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
			<th>Address Line 1</th>
			<th>Address Line 2</th>
			<th>Address Line 3</th>
			<th>City</th>
			<th>State</th>
			<th>Pincode</th>
		</tr>
	<%
	passportService employeeService = new passportService();
			List<Citizen> employeesList = employeeService.getEmployeesListWithAddresses();
			for (Citizen employee :  employeesList) {
		Passport address = employee.getAddress();
	%>
			<tr>
				<td><%= employee.getEmployeeId() %></td>
				<td><%= employee.getFirstName() %></td>
				<td><%= employee.getLastName() %></td>
				<td><%= employee.getDateOfBirth() %></td>
				<td><%= address.getLine1() %></td>
				<td><%= address.getLine2() %></td>
				<td><%= address.getLine3() %></td>
				<td><%= address.getCity() %></td>
				<td><%= address.getState() %></td>
				<td><%= address.getPincode() %></td>
			</tr>
	<%		
		}
	%>
	
	</table>
</body>
</html>