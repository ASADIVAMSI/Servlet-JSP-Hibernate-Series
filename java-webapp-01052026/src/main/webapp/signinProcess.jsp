<%@ page import="entity.Employee" %>
<%@ page import="service.EmployeeService" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Sign In Process</title>
</head>

<body>

    <jsp:useBean id="employee"
                 class="entity.Employee" />

    <jsp:setProperty property="emailAddress"
                     name="employee"
                     param="emadd" />

    <jsp:setProperty property="loginPassword"
                     name="employee"
                     param="lpass" />

<%
    EmployeeService employeeService = new EmployeeService();

    Employee foundEmployee =
            employeeService.signInEmployee(
                    employee.getEmailAddress(),
                    employee.getLoginPassword()
            );

    if (foundEmployee != null) {
%>

        <h2>
            <font color="green">

                Welcome
                <%= foundEmployee.getFirstName() %>
                <%= foundEmployee.getLastName() %>

            </font>
        </h2>

        <p>
            Employee ID:
            <%= foundEmployee.getEmployeeId() %>
        </p>

        <p>
            First Name:
            <%= foundEmployee.getFirstName() %>
        </p>

        <p>
            Last Name:
            <%= foundEmployee.getLastName() %>
        </p>

        <p>
            Date of Birth:
            <%= foundEmployee.getDateOfBirth() %>
        </p>

<%
    } else {
%>

        <h2>
            <font color="red">
                Invalid Access
            </font>
        </h2>

        <a href="signin-form.html">
            Try Again
        </a>

<%
    }
%>

</body>

</html>