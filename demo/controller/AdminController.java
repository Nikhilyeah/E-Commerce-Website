package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")

public class AdminController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/dashboard") //uri--> admin/dashboard
	public String openAdminHome() {
		return "dashboard";
		
	}

	
	
}
