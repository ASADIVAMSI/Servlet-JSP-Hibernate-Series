package com.codegnan.app.javaapp11052026.service;

import java.util.List;

import com.codegnan.app.javaapp11052026.dao.EmployeeDao;
import com.codegnan.app.javaapp11052026.entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean register(Employee employee) {
		return employeeDao.save(employee);
	}
	
	public Employee searchByEmployeeId(int employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeDao.findEmployees();
	}
	
	public List<Employee> searchByLastName(String lastName) {
		return employeeDao.findByLastName(lastName);
	}
	
	public List<String> getFirstNamesList() {
		return employeeDao.findFirstNames();
	}
	
	public boolean modifyDateOfBirth(int employeeId, String dateOfBirth) {
		return employeeDao.updateDateOfBirth(employeeId, dateOfBirth);
	}
	
	public boolean cancelRegistration(int employeeId) {
		return employeeDao.remove(employeeId);
	}
}