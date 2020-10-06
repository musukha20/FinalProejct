package com.project.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

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
	public List<ProductDto> sortProduct(String by, boolean order) {
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

	/*
	 * public ProductDto toListAllProducts() {
	 * 
	 * return this.productDao.getProductById(); }
	 */
	@Override
	public ProductDto get(int id) {
		ProductDto product = productDao.getProductById(id);
		if (product != null) {
			return product;
		} else
			throw new RetailerServiceException("No retailers with id " + id);
	}
	@Override
	public List<Product> getAllProducts() {
		return productDao.fetchAllProducts();

	}

//	public savePic(int id) {
//		//fetching customer data from db
//		ProductDto product=this.get(id);
//				
//
//			//reading the project's deployed folder location
//			String projPath = request.getServletContext().getRealPath("/");
//			System.out.println(projPath); //this will help you understand the above line
//			String tempDownloadPath = projPath + "/downloads/";
//			// creating a folder within the project where we will place the profile pic of the customer getting fetched
//			File f = new File(tempDownloadPath);
//			if(!f.exists())
//			f.mkdir();
//			String targetFile1 = tempDownloadPath + product.getProductImage1();
//			//the original image location
//			String sourceFile = "C:/Users/Windows-10/Desktop/products/" + product.getProductImage1();
//			try {
//			FileCopyUtils.copy(new File(sourceFile), new File(targetFile1));
//			}
//			catch(IOException e) {
//			e.printStackTrace();
//			//maybe for this customer no profile pic
//			}
//			return product;
//		
//	}

}
