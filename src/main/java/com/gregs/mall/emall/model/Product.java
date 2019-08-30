package com.gregs.mall.emall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "products")

public class Product extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	@Column(name = "product_name", nullable = false)
	private String name;
	@Column(name = "product_quantity", nullable = false)
	private int quantity;
	@Column(name = "product_price", nullable = false)
	private int price;
	@Column(name = "product_image", nullable = false)
	private String image_url;
	
	@ManyToOne()
	@JoinColumn(name = "product_category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	private Product_category category;
	
	@ManyToOne()
	@JoinColumn(name = "product_status_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	private Product_status status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	private User seller;

	
	public Product() {}

	public Product(String productName, int productQuantity, int productPrice, Product_category category,
			Product_status status, User seller, String imageUrl) {
		this.name = productName;
		this.quantity = productQuantity;
		this.price = productPrice;
		this.category = category;
		this.status = status;
		this.seller = seller;
		this.image_url = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String productName) {
		this.name = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int productPrice) {
		this.price = productPrice;
	}
	
	public int getSeller_id() {
		return seller.getId();
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Product_category getCategory() {
		return category;
	}

	public void setCategory(Product_category category) {
		this.category = category;
	}

	public Product_status getStatus() {
		return status;
	}

	public void setStatus(Product_status status) {
		this.status = status;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + name + ", productQuantity=" + quantity
				+ ", productPrice=" + price + ", category=" + category + ", status=" + status + ", seller="
				+ seller + "]";
	}
	
	
}
