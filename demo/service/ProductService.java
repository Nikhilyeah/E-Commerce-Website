package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public List<Product>getAllProducts();
	public List<Product>getProductByCategory(Category category);
	public Product getProductById(int id);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	
	

}
