package com.gregs.mall.emall.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gregs.mall.emall.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Page<Product> findByCategoryId(int categoryId, Pageable pageable);
}
