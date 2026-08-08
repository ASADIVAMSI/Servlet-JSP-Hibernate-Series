<%@page import="entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="entity.Employee" id="employee" scope="session"/>
	
	<h2>
	<font color="green">
		Welcome <jsp:getProperty name="employee" property="firstName"/> 
			<jsp:getProperty name="employee" property="lastName"/>
	</font>
	</h2>
</body>
</html>