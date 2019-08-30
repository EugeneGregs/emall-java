package com.gregs.mall.emall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_categories")
@Getter @Setter @NoArgsConstructor @ToString
public class Product_category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_category_id")
	private int id;
	@Column(name = "product_category_name")
	private String categoryName;
	
	public Product_category(String categoryName) { this.categoryName = categoryName; }
	public Product_category() { }
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Product_category [id=" + id + ", categoryName=" + categoryName + "]";
	}
	
}
