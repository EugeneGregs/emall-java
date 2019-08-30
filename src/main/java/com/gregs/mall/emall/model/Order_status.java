package com.gregs.mall.emall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_statuses")
public class Order_status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_status_id", nullable = false)
	private int order_status_id;
	@Column(name = "order_status_name", nullable = false)
	private String order_status_name;
	
	public Order_status() {
	}
	
	public Order_status(String order_status_name) {
		this.order_status_name = order_status_name;
	}
	public int getOrder_status_id() {
		return order_status_id;
	}
	public void setOrder_status_id(int order_status_id) {
		this.order_status_id = order_status_id;
	}
	public String getOrder_status_name() {
		return order_status_name;
	}
	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}

	@Override
	public String toString() {
		return "Order_status [order_status_id=" + order_status_id + ", order_status_name=" + order_status_name + "]";
	}
	
}
