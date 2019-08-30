package com.gregs.mall.emall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gregs.mall.emall.model.Order;
import com.gregs.mall.emall.model.Order_item;
import com.gregs.mall.emall.dao.OrderItemsRepository;
import com.gregs.mall.emall.dao.OrdersRepository;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@GetMapping("/")
	public Page<Order> allOrders(Pageable pageable) {
		return ordersRepository.findAll(pageable);
	}
	
	@GetMapping("/{orderId}/items")
	public Page<Order_item> itemsByOrderId(@PathVariable int orderId, Pageable pageable){
		return orderItemsRepository.findByOrderId(orderId, pageable);
	}
}
