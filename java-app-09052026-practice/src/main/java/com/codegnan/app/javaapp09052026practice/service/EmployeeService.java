package com.codegnan.app.javaapp09052026practice.service;

import com.codegnan.app.javaapp09052026practice.dao.EmployeeDao;
import com.codegnan.app.javaapp09052026practice.entity.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean register (Employee employee) {
		return employeeDao.save(employee);
	}
	
	public Employee searchByEmployeeId(int employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}

}
