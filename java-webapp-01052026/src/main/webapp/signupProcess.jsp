<%@page import="service.EmployeeService"%>
<%@page import="entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="employee" class="entity.Employee"/>
	<jsp:setProperty property="employeeId" name="employee" param="empid"/>
	<jsp:setProperty property="firstName" name="employee" param="fname"/>
	<jsp:setProperty property="lastName" name="employee" param="lname"/>
	<jsp:setProperty property="dateOfBirth" name="employee" param="dob"/>
	<jsp:setProperty property="emailAddress" name="employee" param="emadd"/>
	<jsp:setProperty property="loginPassword" name="employee" param="lpass"/>
	
		<%
		EmployeeService employeeService = new EmployeeService();
				boolean isEmployeeSignedUp = employeeService.signUpEmployee(employee);
				if (isEmployeeSignedUp) {
		%>
			<h2>
			<font color="green">
			Congratulations! Sign Up Successful...
			</font>
			</h2>
			<a href="signin-form.html">Sign In Now</a>
	<%
		} else {
	%>
			<h2>
			<font color="red">
			Error Signing Up...Please Try Again Later...
			</font>
			</h2>
	<%
		}
	%>
</body>
</html>