package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="category_table")
public class Category implements Serializable {
	private static final long serialVersionUID = 23711632L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="category_id")
	private int id;
	
	@Column(name="category_name")
	private String name;
	
	@Column(name="category_description")
	private String description;
	
	@Column(name="category_parent")
	private int parentCat;
	
	@OneToMany
	List<Product> products;
	
	public Category() {
		super();
	}
	public Category(int id, String name, String description, int parentCat) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentCat = parentCat;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category(List<Product> products) {
		super();
		this.products = products;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentCat() {
		return parentCat;
	}
	public void setParentCat(int parentCat) {
		this.parentCat = parentCat;
	}
	
	

}
