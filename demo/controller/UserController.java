package com.example.demo.controller;

import java.security.Principal;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UploadService;
import com.example.demo.service.UserService;
import java.util.*;
import com.example.demo.dto.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UploadService uploadService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam("name")String name,
    								  @RequestParam("email")String email,
    								  @RequestParam("address")String address,
    								  @RequestParam("phone")long phone,
    								  @RequestParam("image")MultipartFile image,
    								  @RequestParam("dob")LocalDate dob,
    								  @RequestParam("username")String username,
    								  @RequestParam("password")String password,
    								  @RequestParam("role")String role
    									) {
        // Set default role (you can customize this logic)
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setImage(image.getOriginalFilename());
        user.setDob(dob);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        
        userService.saveUser(user);
        uploadService.uploadUser(image);
//        userRepository.save(user);
        
        return "redirect:/register"; // Redirect to login page
    }
    
    @GetMapping("admin/user/show")
	public ModelAndView getAllUserDetails(Principal p, ModelAndView mv) {
    	
    	mv.addObject("user_list",userService.getAllUser());
		mv.addObject("user-list",p.getName());
		
		mv.setViewName("user_mgmt");
		
		return mv;	
	}
    
    @GetMapping("/admin/user/add")
    public String showRegistrationForm1() {
        
        return "registration";
    }

    @PostMapping("/admin/user/add")
    public String processRegistration1(@RequestParam("name")String name,
    								  @RequestParam("email")String email,
    								  @RequestParam("address")String address,
    								  @RequestParam("phone")long phone,
    								  @RequestParam("image")MultipartFile image,
    								  @RequestParam("dob")LocalDate dob,
    								  @RequestParam("username")String username,
    								  @RequestParam("password")String password,
    								  @RequestParam("role")String role
    									) {
        // Set default role (you can customize this logic)
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setImage(image.getOriginalFilename());
        user.setDob(dob);
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled("1");
        user.setRole(role);
        
        userService.saveUser(user);
        uploadService.uploadUser(image);
//        userRepository.save(user);
        
        return "redirect:/login"; // Redirect to login page
    }
    
    // User Profile
    @GetMapping("/user/profile")
    public String openUserHome(Principal p, Model model) 
    {
    	
		User user = userService.getUserByUsername(p.getName());
//    	Fetch the user-detail object of logged in user
		model.addAttribute("user_detail",user);
		ArrayList<CartDto> user_cart_list = new ArrayList<CartDto>();
		
		for(CartDto cart: CartController.all_carts) {
			if(cart.getUserDetail().getId() == user.getId()) {
				user_cart_list.add(cart);
			}
		}
		
		model.addAttribute("cart_list", CartController.all_carts);
		return "user_profile";
    	
    }
   
    
}
