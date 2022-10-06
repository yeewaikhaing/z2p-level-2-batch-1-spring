package com.mmit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mmit.model.service.CategoryService;
import com.mmit.model.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService service;
	@Autowired
	private CategoryService catService;
	
	@GetMapping("/")
	public String home() {
		
		return "redirect:/shop";
	}
	
	@GetMapping("/shop")
	public String goShop(ModelMap map) {
		
		map.put("productList", service.findAll());
		map.put("categoryList", catService.findAll());
		
		return "index";
	}
	@GetMapping("/shop/orders")
	public String myOrderPage() {
		
		return "my-order";
	}
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		
		return "register";
	}
	
	@GetMapping("/shop/products/{id}")
	public String singleProduct(ModelMap map, @PathVariable("id") long proudctId) {
		
		map.put("product", service.findById(proudctId));
		
		return "product-detail";
	}
}
