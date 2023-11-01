package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadService;

@Controller
@RequestMapping("/admin/product")
public class productController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UploadService uploadService;
	
	@GetMapping("/add") //'/admin/product/add'
	public ModelAndView openProductsAdd(ModelAndView mv, Principal p) {
		mv.addObject("category_list", categoryService.getAllCategories());
		mv.addObject("user", p.getName());
		mv.setViewName("product_mgmt");
		return mv;
		
	}
	
	@PostMapping("/add")
	public String saveProductData(@RequestParam("name") String name,
								@RequestParam("quantity")int quantity,
								@RequestParam("price") double price,
								@RequestParam("description") String description,
								@RequestParam("image") MultipartFile image,
								@RequestParam("category")int category_id) {
		
		Product product = new Product();
		product.setName(name);
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setDescription(description);
		product.setImage(image.getOriginalFilename());
		product.setCategory(categoryService.getCategoryById(category_id));
		//create product service and add product to database
		productService.saveProduct(product);
		
		//create upload service and upload product image to directory
		
		if(!uploadService.uploadProduct(image)) {
//			return "redirect:/admin/product/add?image_upload_failed=true";
			return "redirect:/admin/product/add?image_upload_failed";
			
		}
		
		return "redirect:/admin/product/show";
		
	}
	
	@GetMapping("/show")
	public ModelAndView getAllProducts(Principal p, ModelAndView mv) {
		mv.addObject("category_list" , categoryService.getAllCategories());
		mv.addObject("user",p.getName());
	
		mv.setViewName("product_mgmt");
		mv.addObject("product_list", productService.getAllProducts());
		return mv;

	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(ModelAndView mv,
									@PathVariable("id") int id,
									Principal p) 
	{
		mv.addObject("edit",true);
		mv.addObject("category_list",categoryService.getAllCategories());
		mv.addObject("user",p.getName());
		mv.addObject("product_list",productService.getAllProducts());
		mv.addObject("edit_product",productService.getProductById(id));
		mv.setViewName("product_mgmt");
		return mv;
		
	}
	
	@PostMapping("/edit")
	public String updateProduct(@RequestParam("id") int id,
	                                  @RequestParam("name") String name,
	                                  @RequestParam("quantity") int quantity,
	                                  @RequestParam("price") double price,
	                                  @RequestParam("description") String description,
	                                  @RequestParam("image") MultipartFile image,
	                                  @RequestParam("orig_image") String origImage,
	                                  @RequestParam("category") int cat_id) {
	    Product product = new Product();
	    product.setId(id);
	    product.setName(name);
	    product.setQuantity(quantity);
	    product.setPrice(price);
	    product.setDescription(description);
	    product.setCategory(categoryService.getCategoryById(cat_id));
	    System.out.println(image.isEmpty());
	    if (image.isEmpty() || image.getOriginalFilename().equals(origImage)) {
	        product.setImage(origImage);
	        // No need to upload image again as the image is the same as the original file.
	    } else {
	        product.setImage(image.getOriginalFilename());
	        uploadService.uploadProduct(image); // Assuming this is the correct method name.
	    }

	    productService.updateProduct(product);
//	    return new ModelAndView("redirect:/admin/product/show");
	    return "redirect:/admin/product/show";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(productService.getProductById(id));
		return "redirect:/admin/product/show";
	}


}
					

