package com.codegnan.app.javaapp08052026.service;

import com.codegnan.app.javaapp08052026.dao.EmployeeDao;
import com.codegnan.app.javaapp08052026.entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean register(Employee employee) {
		return employeeDao.save(employee);
	}
	
	public Employee searchByEmployeeId(int employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}
}