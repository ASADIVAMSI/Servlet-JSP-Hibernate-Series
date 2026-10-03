<!DOCTYPE html>
<%@page import="com.codegnan.app.javawebapp05062026.entity.Employee"%>

<%@page import="java.util.List"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		List<Employee> employeesList = (List) session.getAttribute("EMPLOYEESLIST");
		
		for (Employee employee : employeesList) {
	%>
			Employee ID: <%= employee.getEmployeeId() %><br> 
			First Name: <%= employee.getFirstName() %><br>
			Last Name: <%= employee.getLastName() %><br>
			Date of Birth: <%= employee.getDateOfBirth() %><br>
			Email Address: <%= employee.getEmailAddress() %><br>
			Login Password: <%= employee.getLoginPassword() %><br><br>
	<%
		}
	%>
</body>
</html>