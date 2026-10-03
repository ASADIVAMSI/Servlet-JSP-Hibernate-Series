<%@page import="java.util.List"%>
<%@page import="entity.Employee"%>
<%@page import="service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String lastName = request.getParameter("lname");
	
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employeesList = employeeService.searchEmployeeByLastName(lastName);
		
		if(!(employeesList.isEmpty())) {
			for (Employee employee :  employeesList) {
	%>
				Employee ID: <%= employee.getEmployeeId() %><br>
				First Name: <%= employee.getFirstName() %><br>
				Last Name: <%= employee.getLastName() %><br>
				Date of Birth: <%= employee.getDateOfBirth() %><br><br>
	<%	
			}
		} else {
	%>
			<h2>
				<font color="red">
					No Employee found by last name <%= lastName %>.
				</font>
			</h2>
	<%
		}
	%>
	
	</table>
</body>
</html>