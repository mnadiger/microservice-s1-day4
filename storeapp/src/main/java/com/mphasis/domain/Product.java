package com.mphasis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Details")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "product_price")
	private Double price;

	public Product() {
	}

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
