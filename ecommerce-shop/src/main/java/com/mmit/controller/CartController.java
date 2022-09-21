package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

	@GetMapping("/cart/detail")
	public String home() {
		
		return "cart";
	}
	
	@GetMapping("/cart/checkout")
	public String checkoutPage() {
		
		return "checkout";
	}
}
