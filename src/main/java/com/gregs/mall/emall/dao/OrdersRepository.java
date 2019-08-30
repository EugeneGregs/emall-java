package com.gregs.mall.emall.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregs.mall.emall.model.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
