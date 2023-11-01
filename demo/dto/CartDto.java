package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public class CartDto implements Serializable{
	private static final long serialVersionUID = 2134523412L;
	private int id;
	private Product product;
	private int quantity;
	private User userDetail;
	
	public CartDto() {
		super();
	}
	
	public CartDto(int id, Product product, int quantity, User userDetail) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.userDetail = userDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(User userDetail) {
		this.userDetail = userDetail;
	}
	
	

}
