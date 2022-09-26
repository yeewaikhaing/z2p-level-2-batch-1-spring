package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmit.controller.request.OrderRequestData;

@Controller
public class CartController {

	@GetMapping("/cart/detail")
	public String home() {
		
		return "cart";
	}
	
	@GetMapping("/cart/checkout")
	public String checkoutPage(ModelMap map) {
		
		map.put("name", "Aung Aung");
		map.put("phone", "0912345678");
		map.put("email", "aungaung@gmail.com");
		map.put("address", "Yangon");
		
		return "checkout";
	}
	
	@PostMapping("/cart/place-order")
	public @ResponseBody String makeOrder(@RequestBody OrderRequestData obj) {
		System.out.println("items : " + obj.getOrderItems());
		System.out.println("receiver: " + obj.getReceiver());
		
		return "ok";
	}
}
