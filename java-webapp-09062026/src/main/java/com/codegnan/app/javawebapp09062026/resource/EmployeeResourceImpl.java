package com.codegnan.app.javawebapp09062026.resource;

import org.springframework.stereotype.Component;

import com.codegnan.app.javawebapp09062026.entity.Employee;
import com.codegnan.app.javawebapp09062026.service.EmployeeService;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Component
@Path("/employee") //ENDPOINT URL
public class EmployeeResourceImpl implements EmployeeResource{
	
	private EmployeeService employeeService;
	
	private EmployeeResourceImpl(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//Method must be String or entity class type only.
	/*
	 POST = CREATE/INSERT
	 GET  = READ / SELECT
	 PUT / PATCH  = UPDATE / MODIFY
	 DELETE = DELETE / REMOVE
	*/
	@POST
	public String signUp(@FormParam("fname") String firstName, @FormParam("lname") String lastName, @FormParam("dob") String dateOfBirth, @FormParam("emadd")String emailAddress,
			@FormParam("lpass") String loginPassword) {
		String responseText = "failure";
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDateOfBirth(dateOfBirth);
		employee.setEmailAddress(emailAddress);
		employee.setLoginPassword(loginPassword);
		
		boolean isSignUpSuccessful =  employeeService.signUp(employee);
		if(isSignUpSuccessful) {
			responseText = "success";
		}
		return responseText; 
	}
}
