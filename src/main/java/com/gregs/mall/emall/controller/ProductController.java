package com.gregs.mall.emall.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregs.mall.emall.dao.ProductRepository;
import com.gregs.mall.emall.exception.ResourceNotFoundException;
import com.gregs.mall.emall.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController{
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public Page<Product> allProducts(Pageable pageable){
		return productRepository.findAll(pageable);
	}
	
	@GetMapping("/{productId}")
	public Product findById(@PathVariable int productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId " + productId +" not found"));
	}
}
