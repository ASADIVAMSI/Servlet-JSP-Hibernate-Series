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
	<%
	int employeeId = Integer.parseInt(request.getParameter("empid"));
			
		passportService employeeService = new passportService();
		Citizen employee = employeeService.searchEmployeeById(employeeId);
		
		if(employee != null) {
	%>
				Employee ID: <%= employee.getEmployeeId() %><br>
				First Name: <%= employee.getFirstName() %><br>
				Last Name: <%= employee.getLastName() %><br>
				Date of Birth: <%= employee.getDateOfBirth() %>
	<%	
		} else {
	%>
			<h2>
				<font color="red">
					No Employee found by employee id <%= employeeId %>.
				</font>
			</h2>
	<%
		}
	%>
	
	</table>
</body>
</html>