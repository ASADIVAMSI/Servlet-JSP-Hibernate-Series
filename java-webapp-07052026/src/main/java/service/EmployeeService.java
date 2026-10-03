package service;

import java.util.List;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean register(Employee employee) {
		return employeeDao.save(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeDao.findEmployees();
	}
	
	public List<Employee> getEmployeesListWithAddresses() {
		return employeeDao.findEmployeesWithAddresses();
	}
	
	public Employee searchByEmployeeId(int employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}
	
	public List<Employee> searchByLastName(String lastName) {
		return employeeDao.findByLastName(lastName);
	}
	
	public boolean cancelRegistration(int employeeId) {
		return employeeDao.remove(employeeId);
	}
	
	public boolean modifyDateOfBirth(int employeeId, String dateOfBirth) {
		return employeeDao.updateDateOfBirth(employeeId, dateOfBirth);
	}
}