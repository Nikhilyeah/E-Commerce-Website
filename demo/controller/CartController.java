package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CartDto;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;


@Controller
public class CartController {
	
	public static ArrayList<CartDto> all_carts = new ArrayList<CartDto>();
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/user/cart/add/{pid}")
	public String addCart(Principal p, 
			@RequestParam("quantity")int quantity,
			@PathVariable("pid") int pid) {
		
		
		CartDto cart = new CartDto();
		cart.setProduct(productService.getProductById(pid));
		cart.setUserDetail(userService.getUserByUsername(p.getName()));
		cart.setQuantity(quantity);
		all_carts.add(cart);
		
		return "redirect:/user/profile";
		
	}
}
