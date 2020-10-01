package com.project.repository;

import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Retailer;

public interface RetailerRepository {

	int save(Retailer retailer);

	Retailer findById(int id);

	int findByEmailAndPassword(String email, String password);

	boolean isRetailerPresent(String email);

}