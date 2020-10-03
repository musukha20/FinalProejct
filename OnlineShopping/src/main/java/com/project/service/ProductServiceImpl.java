package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.ProductDto;
import com.project.repository.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDto> sortProduct(String by, boolean order){
		return this.productDao.sortProduct(by, order);
	}
}
