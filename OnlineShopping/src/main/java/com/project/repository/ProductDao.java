package com.project.repository;

import java.util.List;
import com.project.dto.ProductDto;
import com.project.entity.Product;

public interface ProductDao {

	public List<ProductDto> search(String keyword);
	public List<ProductDto> sortProductByFactors(String by , boolean order ); 
	public ProductDto getProductById(int productId);
	//public ProductDto getProductById();
	List<Product> fetchAllProducts();
	public List<ProductDto> filterProduct(String brand, double start, double end); 
}
