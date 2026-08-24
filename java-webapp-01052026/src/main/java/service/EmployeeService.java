package service;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee signInEmployee(String emailAddress, String loginPassword) {
		return employeeDao.findEmployeeByEmailAddressAndPassword(emailAddress, loginPassword);
	}
					
	public boolean signUpEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
}