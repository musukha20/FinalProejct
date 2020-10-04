package com.project.service;

import java.util.List;

import com.project.dto.ProductDto;


public interface ProductService {

	public List<ProductDto> sortProduct(String by, boolean order);
	public List<ProductDto> search(String keyword);
	List<ProductDto> toListAllProducts(int productId); 

}