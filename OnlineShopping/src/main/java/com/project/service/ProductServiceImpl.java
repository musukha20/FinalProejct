package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dto.ProductDto;
import com.project.entity.Product;
import com.project.entity.Retailer;
import com.project.exception.RetailerServiceException;
import com.project.repository.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDto> sortProduct(String by, boolean order){
		return this.productDao.sortProductByFactors(by, order);
	}

	@Override
	public List<ProductDto> search(String keyword) {
		return productDao.search(keyword);
	}

	@Override
	public ProductDto toListAllProducts(int productId) {
		
		return this.productDao.getProductById(productId);
	} 
	
	/*public ProductDto toListAllProducts() {
		
		return this.productDao.getProductById();
	}*/
	@Override
	public ProductDto get(int id) {
	ProductDto product = productDao.getProductById(id);
	if(product != null) {
	return product;
	}
	else
	throw new RetailerServiceException("No retailers with id "+id);
	}
	
}
