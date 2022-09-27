package com.mmit.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmit.model.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long>{

}
