package com.codegnan.app.javawebapp05062026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codegnan.app.javawebapp05062026.service.EmployeeService;

@Controller
@RequestMapping("/delete")
public class DeleteEmployeeProcessController {

    private EmployeeService employeeService;

    public DeleteEmployeeProcessController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String performOperation(@RequestParam("id") int employeeId) {

        employeeService.deleteEmployee(employeeId);

        return "redirect:/emplist";
    }
}