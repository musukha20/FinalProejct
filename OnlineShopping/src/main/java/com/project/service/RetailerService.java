package com.project.service;

import com.project.entity.Admin;
import com.project.entity.Product;
import com.project.entity.Retailer;

public interface RetailerService {

	int register(Retailer retailer);
	
	public int additionOfProduct(Product product, Retailer retailer);

	Retailer get(int id);

	Retailer login(String email, String password);

	

}