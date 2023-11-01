package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	public static final String UPLOADS_PATH="//users//hunter//desktop//demoapp_image";
	
	public boolean uploadProduct(MultipartFile image);
	
	public boolean uploadUser(MultipartFile image);
	
	
	
	

	
	
	
}
