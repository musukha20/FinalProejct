package com.project.service;

import java.util.List;
import com.project.dto.ProductDto;
import com.project.entity.Product;


public interface ProductService {

	public List<ProductDto> sortProduct(String by, boolean order);
	public List<ProductDto> search(String keyword);
	ProductDto toListAllProducts(int productId); 
	//ProductDto toListAllProducts(); 
	ProductDto get(int id);
	List<Product> getAllProducts();
	public List<ProductDto> filterProduct(String brand, double start, double end);
}