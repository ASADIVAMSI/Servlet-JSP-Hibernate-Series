<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring-form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring-form:form action="signup" method="post" modelAttribute="employee">
		First Name <spring-form:input path="firstName"/> <spring-form:errors path="firstName"/><br> 
		Last Name <spring-form:input path="lastName"/> <spring-form:errors path="lastName"/><br> 
		Date Of Birth <spring-form:input path="dateOfBirth"/> <spring-form:errors path="dateOfBirth"/><br> 
		Email Address <spring-form:input path="emailAddress"/> <spring-form:errors path="emailAddress"/><br> 
		Login Password <spring-form:password path="loginPassword"/> <spring-form:errors path="loginPassword"/><br>
		<spring-form:button>Sign Up</spring-form:button>
	</spring-form:form>
</body>
</html>