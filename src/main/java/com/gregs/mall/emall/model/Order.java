package com.gregs.mall.emall.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "order_status_id", nullable = false)
	private Order_status order_status;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "payment_method_id")
	private Payment_method payment_method;

	public Order() {
	}

	public Order(Order_status order_status, Payment_method payment_method) {
		this.order_status = order_status;
		this.payment_method = payment_method;
	}

	public int getOrder_id() {
		return id;
	}

	public void setOrder_id(int order_id) {
		this.id = order_id;
	}

	public Order_status getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Order_status order_status) {
		this.order_status = order_status;
	}

	public Payment_method getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(Payment_method payment_method) {
		this.payment_method = payment_method;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + id + ", order_status=" + order_status
				+ ", payment_method=" + payment_method + "]";
	}
		
}
