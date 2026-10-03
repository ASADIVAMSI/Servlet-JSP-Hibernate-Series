<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Update DOB</title>
</head>
<body>

<h2>Update Date of Birth</h2>

<form action="update" method="post">

    Employee ID:
    <input type="text" name="employeeId">
    <br><br>

    Date of Birth:
    <input type="date" name="dateOfBirth">
    <br><br>

    <input type="submit" value="update">

</form>

</body>
</html>