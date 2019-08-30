package com.gregs.mall.emall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gregs.mall.emall.model.Product_category;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_category, Integer>{

}
