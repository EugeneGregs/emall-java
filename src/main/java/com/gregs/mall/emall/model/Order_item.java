package com.gregs.mall.emall.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class Order_item extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private int order_item_id;
	
	@Column(name = "order_item_price")
	private int order_item_price;
	
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	public Order_item() {
	}

	public Order_item(int order_item_price, Product product) {
		this.order_item_price = order_item_price;
		this.product = product;
	}

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getOrder_item_price() {
		return order_item_price;
	}

	public void setOrder_item_price(int order_item_price) {
		this.order_item_price = order_item_price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Order_item [order_item_id=" + order_item_id + ", order_item_price=" + order_item_price + ", product="
				+ product + "]";
	}	
}
