package com.gregs.mall.emall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_methods")
public class Payment_method {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_method_id")
	private int payment_method_id;
	@Column(name = "payment_method_name")
	private String payment_method_name;
	
	public Payment_method() {
	}
	
	public Payment_method(String payment_method_name) {
		this.payment_method_name = payment_method_name;
	}
	public int getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(int payment_method_id) {
		this.payment_method_id = payment_method_id;
	}
	public String getPayment_method_name() {
		return payment_method_name;
	}
	public void setPayment_method_name(String payment_method_name) {
		this.payment_method_name = payment_method_name;
	}

	@Override
	public String toString() {
		return "Payment_method [payment_method_id=" + payment_method_id + ", payment_method_name=" + payment_method_name
				+ "]";
	}

}
