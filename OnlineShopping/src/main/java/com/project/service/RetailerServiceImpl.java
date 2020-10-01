package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Retailer;
import com.project.exception.RetailerServiceException;
import com.project.repository.RetailerRepository;

@Service
@Transactional
public class RetailerServiceImpl implements RetailerService {
	
	@Autowired
	private RetailerRepository retailerRepository;
	
	
	@Override
	public int register(Retailer retailer) {
		if(!retailerRepository.isRetailerPresent(retailer.getEmail())) {
			int id = retailerRepository.save(retailer);
			return id;
		}
		else
			throw new RetailerServiceException("Retailer Already Registered");
	}
}
