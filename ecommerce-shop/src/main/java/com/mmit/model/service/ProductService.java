package com.mmit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmit.model.entity.Product;
import com.mmit.model.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> findAll() {
		
		return repo.findAll();
	}

	public Product findById(long proudctId) {
		
		return repo.findById(proudctId).orElse(new Product());
	}
	
	
	
}
