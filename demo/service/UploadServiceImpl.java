package com.example.demo.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service

public class UploadServiceImpl implements UploadService{

	@Override
	public boolean uploadProduct(MultipartFile image) {
		boolean status= false;
		String uploadDir = UPLOADS_PATH + File.separator +"product_image";
		File productDir = new File(uploadDir);
		if(!productDir.exists()){
			productDir.mkdirs();
		}
		File productImage= new File(uploadDir+File.separator + image.getOriginalFilename());
		try {
			image.transferTo(productImage);
		} catch (IllegalStateException e) {	
			status = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean uploadUser(MultipartFile image) {
	
		boolean status=false;
		String uploadDir = UPLOADS_PATH + File.separator + "user_image";
		File userDir = new File(uploadDir);
		if(!userDir.exists()){
			userDir.mkdirs();
		}
		File userImage = new File(uploadDir+File.separator  + image.getOriginalFilename());
		
		try {
			image.transferTo(userImage);
		} catch  (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	

}
