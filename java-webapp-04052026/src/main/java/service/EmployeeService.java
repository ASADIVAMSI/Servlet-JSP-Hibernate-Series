package service;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean registerNewEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
}