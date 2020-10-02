package com.project.service;

import com.project.entity.Product;
import com.project.entity.Retailer;

public interface RetailerService {

	int register(Retailer retailer);
	
	public int additionOfProduct(Product product, Retailer retailer);

}