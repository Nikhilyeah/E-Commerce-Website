package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// opens category jsp page
	@GetMapping("/admin/category/add")
	public String openCategoryPage() {
		return "category";
	}

	// save data from Category page
	@PostMapping("/admin/category/add")
	public String saveCategory(@RequestParam("cat_name") String name,
			@RequestParam("cat_description") String description, @RequestParam("cat_parent") int parentCat) {
		Category cat = new Category();
		cat.setName(name);
		cat.setDescription(description);
		cat.setParentCat(parentCat);
		// save by calling service
		categoryService.saveCategory(cat);
		return "redirect:/admin/category/show";

	}

	@GetMapping("/admin/category/show")
	public String showCategoryData(Model model) {
		model.addAttribute("category_list", categoryService.getAllCategories());
		return "category";
	}

	@GetMapping("/admin/category/edit/{id}")
	public String editCategory(Model model, @PathVariable("id") int cid) {
		model.addAttribute("category_list", categoryService.getAllCategories());
		Category cat = categoryService.getCategoryById(cid);
		model.addAttribute("cat_edit", cat);
		model.addAttribute("edit", true);
		return "category";

	}
	
	@PostMapping("admin/category/edit")
	public String updateCategory(@RequestParam("cat_id") int id, 
									@RequestParam("cat_name") String name, 
									@RequestParam("cat_description") String description, 
									@RequestParam("cat_parent")	int parentCat) {
		Category cat = new Category(id, name, description, parentCat);
		categoryService.updateCategory(cat);
		
		return"redirect:/admin/category/show";
	}
	
	
	@GetMapping("/admin/category/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		//deleting  using persistent object 
		//Category cat = categoryService.getCategoryById(id);
		//categoryService.deleteCategory(cat);
		
		//deleting using transient object
		Category cat = new Category();
		cat.setId(id);
		categoryService.deleteCategory(cat);
		return "redirect:/admin/category/show";
	}

}
