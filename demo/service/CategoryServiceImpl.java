package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	
	@Override
	public void saveCategory(Category category) {
		categoryDao.save(category);
		
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id).get();
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.saveAndFlush(category);
		
		
	}

	@Override
	public void deleteCategory(Category category) {
		categoryDao.delete(category);
		
	}

}
