package com.gregs.mall.emall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gregs.mall.emall.model.Product_status;

@Repository
public interface ProductstatusRepository extends JpaRepository<Product_status, Integer> {

}
