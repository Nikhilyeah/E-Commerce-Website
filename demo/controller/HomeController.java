package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public String openHome() {
		return"index";
	}
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String openAbout() {
		return "about";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String openProduct(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		
		return "products";
	}

}
