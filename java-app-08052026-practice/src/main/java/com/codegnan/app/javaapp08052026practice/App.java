package com.codegnan.app.javaapp08052026practice;

import com.codegnan.app.javaapp08052026practice.entity.Employee;
import com.codegnan.app.javaapp08052026practice.service.EmployeeService;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee();
        
        employee.setFirstName("vamsi");
        employee.setLastName("kumar");
        employee.setDateOfBirth("2003-06-15");
        
        EmployeeService employeeService = new EmployeeService();
        boolean isEmployeeRegistered = employeeService.register(employee);
        if(isEmployeeRegistered) {
        		System.out.println("Employee successfully registered");
        }else {
    		    System.out.println("Error registering employee.");

        }
    }
}
