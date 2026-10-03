package service;

import java.util.List;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean registerNewEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeDao.findEmployees();
	}
	
	public List<Employee> getEmployeesListWithAddresses() {
		return employeeDao.findEmployeesAndAddresses();
	}
	
	public Employee searchEmployeeById(int employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}
	
	public List<Employee> searchEmployeeByLastName(String lastName) {
		return employeeDao.findByLastName(lastName);
	}
}