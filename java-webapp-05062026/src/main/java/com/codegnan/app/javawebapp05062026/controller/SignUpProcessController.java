package com.codegnan.app.javawebapp05062026.controller;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegnan.app.javawebapp05062026.entity.Employee;
import com.codegnan.app.javawebapp05062026.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpProcessController {
	private EmployeeService employeeService;

	private SignUpProcessController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String getSignUpForm(@ModelAttribute Employee employee) {
		return "employee-signup-form";
	}

	@PostMapping
	public String performSignUpOperation(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "employee-signup-form";
		} else {
			boolean isSignUpDone = employeeService.signUp(employee);

			if (isSignUpDone) {
				return "employee-signup-success";
			} else {
				return "employee-signup-failure";
			}
		}
	}
}