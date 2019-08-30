package com.gregs.mall.emall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_statuses")
public class Shopping_cart_status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_cart_status_id")
	private int shopping_cart_status_id;
	@Column(name = "shopping_cart_status_name")
	private String shopping_cart_status_name;
		
	public Shopping_cart_status() {
	}
	public Shopping_cart_status(String shopping_cart_status_name) {
		this.shopping_cart_status_name = shopping_cart_status_name;
	}
	public int getShopping_cart_status_id() {
		return shopping_cart_status_id;
	}
	public void setShopping_cart_status_id(int shopping_cart_status_id) {
		this.shopping_cart_status_id = shopping_cart_status_id;
	}
	public String getShopping_cart_status_name() {
		return shopping_cart_status_name;
	}
	public void setShopping_cart_status_name(String shopping_cart_status_name) {
		this.shopping_cart_status_name = shopping_cart_status_name;
	}
	
	@Override
	public String toString() {
		return "Shopping_cart_status [shopping_cart_status_id=" + shopping_cart_status_id
				+ ", shopping_cart_status_name=" + shopping_cart_status_name + "]";
	}
		
}
