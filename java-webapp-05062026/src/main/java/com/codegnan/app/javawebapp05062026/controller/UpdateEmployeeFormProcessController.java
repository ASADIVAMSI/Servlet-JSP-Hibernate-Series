package com.codegnan.app.javawebapp05062026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codegnan.app.javawebapp05062026.entity.Employee;
import com.codegnan.app.javawebapp05062026.service.EmployeeService;

@Controller
@RequestMapping("/edit")
public class UpdateEmployeeFormProcessController {

    private EmployeeService employeeService;

    public UpdateEmployeeFormProcessController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String performOperation(@RequestParam("id") int employeeId, Model model) {

        Employee employee = employeeService.getEmployeeById(employeeId);

        model.addAttribute("employee", employee);

        return "employee-update-form";
    }
}