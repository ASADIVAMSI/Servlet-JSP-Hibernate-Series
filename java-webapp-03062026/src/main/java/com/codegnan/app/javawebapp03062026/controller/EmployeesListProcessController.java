package com.codegnan.app.javawebapp03062026.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegnan.app.javawebapp03062026.entity.Employee;
import com.codegnan.app.javawebapp03062026.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emplist")
public class EmployeesListProcessController {
	private EmployeeService employeeService;

	private EmployeesListProcessController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String performOperation(HttpServletRequest request) {
		List<Employee> employeesList = employeeService.getEmployeesList();

		HttpSession session = request.getSession();
		session.setAttribute("EMPLOYEESLIST", employeesList);

		return "employees-list";
	}
}