package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Product;
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

	@Override
	public int additionOfProduct(Product product, Retailer retailer) {
		retailerRepository.addProduct(product, retailer);
		return 0;
	}
	
	@Override
	public Retailer get(int id) {
	Retailer retailer = retailerRepository.findById(id);
	if(retailer != null) {
	return retailer;
	}
	else
	throw new RetailerServiceException("No retailers with id "+id);
	}

	/*@Override
	public void update(Retailer retailer) {
	RetailerRepository.save(retailer);
	}*/
}
