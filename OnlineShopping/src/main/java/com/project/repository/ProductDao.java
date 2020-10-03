package com.project.repository;

import java.util.List;

import com.project.dto.ProductDto;
import com.project.entity.Product;

public interface ProductDao {

	public List<ProductDto> search(String keyword);
	public List<ProductDto> sortProduct(String by , boolean order );
}
