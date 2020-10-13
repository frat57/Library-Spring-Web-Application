package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@PostMapping("/authenticateTheUser")
	public String showHomePage() {
		System.out.println("Buradayız ----------------->>>>>>>>>>>>>>>>>");
		return "redirect:/book/list";	
	}
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";	
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









