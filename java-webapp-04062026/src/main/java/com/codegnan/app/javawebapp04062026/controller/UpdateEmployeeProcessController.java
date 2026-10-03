package com.codegnan.app.javawebapp04062026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegnan.app.javawebapp04062026.entity.Employee;
import com.codegnan.app.javawebapp04062026.service.EmployeeService;

@Controller
@RequestMapping("/update")
public class UpdateEmployeeProcessController {

    private EmployeeService employeeService;

    public UpdateEmployeeProcessController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public String performOperation(Employee employee) {

        employeeService.updateEmployee(employee);

        return "redirect:/emplist";
    }
}