package com.codegnan.app.javawebapp03062026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegnan.app.javawebapp03062026.entity.Employee;
import com.codegnan.app.javawebapp03062026.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/signin")
public class SignInProcessController {
	private EmployeeService employeeService;

	private SignInProcessController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String getSignInForm() {
		return "employee-signin-form";
	}

	@PostMapping
	public String performSignInOperation(@ModelAttribute("employee") Employee employee, HttpSession session) {
	
		Employee foundEmployee = employeeService.signIn(employee.getEmailAddress(), employee.getLoginPassword());

		if (foundEmployee != null) {
			session.setAttribute("EMPLOYEE", foundEmployee);

			return "employee-signin-success";
		} else {
			return "employee-signin-failure";
		}
	}
}