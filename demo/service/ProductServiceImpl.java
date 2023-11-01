package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productDao.findAll();
	}

	@Override
	public List<Product> getProductByCategory(Category category) {
	
		return productDao.findByCategory(category);
	}

	@Override
	public Product getProductById(int id) {
		
		return productDao.findById(id).get();
	}

	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
		
	}

}
