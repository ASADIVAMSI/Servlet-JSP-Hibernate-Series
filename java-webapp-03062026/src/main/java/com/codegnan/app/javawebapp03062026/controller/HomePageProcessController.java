package com.codegnan.app.javawebapp03062026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageProcessController {
	@GetMapping
	public String getHomePage() {
		return "index";
	}
}