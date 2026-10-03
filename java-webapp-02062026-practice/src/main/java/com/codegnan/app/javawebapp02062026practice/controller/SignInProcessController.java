package com.codegnan.app.javawebapp02062026practice.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import jakarta.servlet.http.HttpSession;

@Controller
public class SignInProcessController {
	@GetMapping("/signin")
	public String getSignInForm() {
		return "/WEB-INF/jsp/signin-form.jsp";
	}
	
}