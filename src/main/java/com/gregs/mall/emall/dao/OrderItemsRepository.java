package com.gregs.mall.emall.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gregs.mall.emall.model.Order_item;

public interface OrderItemsRepository extends JpaRepository<Order_item, Integer> {

	public Page<Order_item> findByOrderId(int order_id, Pageable pageable);
}
