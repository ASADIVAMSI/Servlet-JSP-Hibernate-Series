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
			boolean isRegistrationCancelled = employeeService.cancelRegistration(employeeId);
			
			if(isRegistrationCancelled) {
	%>
			<h2>
				<font color="green">
					Employee registration cancellation successful.
				</font>
			</h2>
	<%	
		} else {
	%>
			<h2>
				<font color="red">
					No Employee found by employee id <%= employeeId %> OR Error cancelling employee registration.
				</font>
			</h2>
	<%
		}
	%>
	
	</table>
</body>
</html>