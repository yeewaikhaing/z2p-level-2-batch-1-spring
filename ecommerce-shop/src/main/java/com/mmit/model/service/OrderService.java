package com.mmit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmit.model.entity.Orders;
import com.mmit.model.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo repo;

	public Orders save(Orders new_order) {
		
		return repo.save(new_order);
	}
}
