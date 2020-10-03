package com.project.service;

import java.util.List;

import com.project.dto.ProductDto;

public interface ProductService {

	List<ProductDto> sortProduct(String by, boolean i);

}