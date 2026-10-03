package com.codegnan.app.javaapp11052026;

import java.util.List;

import com.codegnan.app.javaapp11052026.entity.Employee;
import com.codegnan.app.javaapp11052026.service.EmployeeService;

public class App {
    public static void main(String[] args) {
    		EmployeeService employeeService = new EmployeeService();
    		
    		List<String> firstNamesList = employeeService.getFirstNamesList();
    		for (String firstName : firstNamesList) {
    			System.out.println(firstName);
    		}
    		
    		/*List<Employee> employeesList = employeeService.searchByLastName("Sharma");
    		for (Employee employee : employeesList) {
    			System.out.println(employee);
    		}*/
    		
    		/*List<Employee> employeesList = employeeService.getEmployeesList();
    		for (Employee employee : employeesList) {
    			System.out.println(employee);
    		}*/
    		
    		/*boolean isRegistrationCancelled = employeeService.cancelRegistration(1002);
    		if (isRegistrationCancelled) {
    			System.out.println("Registration cancelled successfully.");
    		} else {
    			System.out.println("Employee not found with the given employee id OR error cancelling registration.");
    		}*/
    		
    		/*boolean isDateOfBirthUpdated = employeeService.modifyDateOfBirth(1001, "2005-10-25");
    		if (isDateOfBirthUpdated) {
    			System.out.println("Date of birth successfully updated.");
    		} else {
    			System.out.println("Employee not found with the given employee id OR error updating date of birth.");
    		}*/
    		
    		/*//Employee employee = employeeService.searchByEmployeeId(1001);
    		Employee employee = employeeService.searchByEmployeeId(101);
    		if (employee != null) {
    			System.out.println("Employee ID: " + employee.getEmployeeId());
    			System.out.println("First Name: " + employee.getFirstName());
    			System.out.println("Last Name: " + employee.getLastName());
    			System.out.println("Date of Birth: " + employee.getDateOfBirth());
    		} else {
    			System.out.println("No employee found with given employee id.");
    		}*/
    		
    	
       /* Employee employee = new Employee();
        employee.setFirstName("Akshat");
        employee.setLastName("Kumar");
        employee.setDateOfBirth("2000-12-31");       
        
        boolean isEmployeeRegistered = employeeService.register(employee);
        if (isEmployeeRegistered) {
        		System.out.println("Employee successfully registered");
        } else {
        		System.out.println("Error registering employee");
        }*/
    }
}