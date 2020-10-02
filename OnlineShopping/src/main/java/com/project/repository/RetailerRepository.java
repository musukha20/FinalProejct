package com.project.repository;

import com.project.entity.Retailer;

public interface RetailerRepository {

	int save(Retailer retailer);

	Retailer findById(int id);

	int findByEmailAndPassword(String email, String password);

	boolean isRetailerPresent(String email);

}