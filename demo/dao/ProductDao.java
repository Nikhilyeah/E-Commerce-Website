package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
	
	public List<Product>findByCategory(Category category);
	public List<Product>findByName(String name);
	
}
