package com.project.dto;

import org.springframework.web.multipart.MultipartFile;

public class PicUpload {
	
	private int retailerId;
	private MultipartFile productImage1;
	private MultipartFile productImage2;
	private MultipartFile productImage3;
	private MultipartFile productImage4;
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public MultipartFile getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(MultipartFile productImage1) {
		this.productImage1 = productImage1;
	}
	public MultipartFile getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(MultipartFile productImage2) {
		this.productImage2 = productImage2;
	}
	public MultipartFile getProductImage3() {
		return productImage3;
	}
	public void setProductImage3(MultipartFile productImage3) {
		this.productImage3 = productImage3;
	}
	public MultipartFile getProductImage4() {
		return productImage4;
	}
	public void setProductImage4(MultipartFile productImage4) {
		this.productImage4 = productImage4;
	}
	
	
}
