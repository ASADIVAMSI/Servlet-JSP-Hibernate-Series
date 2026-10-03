<%@page import="service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="employee" class="entity.Employee"/>
	<jsp:setProperty property="firstName" name="employee" param="fname"/>
	<jsp:setProperty property="lastName" name="employee" param="lname"/>
	<jsp:setProperty property="dateOfBirth" name="employee" param="dob"/>
		
	<jsp:useBean id="address" class="entity.Address"/>
	<jsp:setProperty property="line1" name="address" param="line1"/>
	<jsp:setProperty property="line2" name="address" param="line2"/>
	<jsp:setProperty property="line3" name="address" param="line3"/>
	<jsp:setProperty property="city" name="address" param="city"/>
	<jsp:setProperty property="state" name="address" param="state"/>
	<jsp:setProperty property="pincode" name="address" param="pincode"/>
	
	<jsp:setProperty property="address" name="employee" value="<%=address%>"/>
	
	<%
	EmployeeService employeeService = new EmployeeService();
				boolean isEmployeeRegistered = employeeService.registerNewEmployee(employee);
				if (isEmployeeRegistered) {
		%>
			<h2>
			<font color="green">
				New employee registration successful.
			</font>
			</h2>
	<%
		} else {
	%>
			<h2>
			<font color="red">
				Error registering new employee.
			</font>
			</h2>
	<%
		}
	%>
</body>
</html>