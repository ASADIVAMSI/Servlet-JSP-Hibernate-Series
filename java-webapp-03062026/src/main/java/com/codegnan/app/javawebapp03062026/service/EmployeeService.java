package com.codegnan.app.javawebapp03062026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codegnan.app.javawebapp03062026.dao.EmployeeDao;
import com.codegnan.app.javawebapp03062026.entity.Employee;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public boolean signUp(Employee employee) {
		Employee newEmployee = employeeDao.save(employee);

		if (newEmployee != null) {
			return true;
		}

		return false;
	}

	@Transactional
	public List<Employee> getEmployeesList() {
		return employeeDao.findAll();
	}

	@Transactional
	public Employee signIn(String emailAddrees, String loginPassword) {
		return employeeDao.findByEmailAddressAndLoginPassword(emailAddrees, loginPassword);
	}
}