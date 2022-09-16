package com.mmit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmit.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
