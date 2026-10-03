package com.codegnan.app.javaapp09052026;
import com.codegnan.app.javaapp09052026.entity.Employee;
import com.codegnan.app.javaapp09052026.service.EmployeeService;

public class App {
    public static void main(String[] args) {
    		EmployeeService employeeService = new EmployeeService();
    		
    		//Employee employee = employeeService.searchByEmployeeId(1001);
    		Employee employee = employeeService.searchByEmployeeId(101);
    		if (employee != null) {
    			System.out.println("Employee ID: " + employee.getEmployeeId());
    			System.out.println("First Name: " + employee.getFirstName());
    			System.out.println("Last Name: " + employee.getLastName());
    			System.out.println("Date of Birth: " + employee.getDateOfBirth());
    		} else {
    			System.out.println("No employee found with given employee id.");
    		}
    		
    	
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