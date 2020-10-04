package com.project.dto;

public class ProductDto {
	
	private String productImage1;
	private String productImage2;
	private String productImage3;
	private String productImage4;
	private String description;
	private int productId;
	private String name;
	private String brand;
	private Double price;
	
	
	public ProductDto(String productImage1, String productImage2, String productImage3, String productImage4,
			String description, int productId, String name, String brand, Double price) {
		super();
		this.productImage1 = productImage1;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.productImage4 = productImage4;
		this.description = description;
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.price = price;
		
	}
	public String getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}
	public String getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}
	public String getProductImage3() {
		return productImage3;
	}
	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}
	public String getProductImage4() {
		return productImage4;
	}
	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}