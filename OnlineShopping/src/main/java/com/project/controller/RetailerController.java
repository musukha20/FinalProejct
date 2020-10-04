package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AddProductStatus;
import com.project.dto.Status;
import com.project.entity.Product;
import com.project.entity.Retailer;
import com.project.exception.RetailerServiceException;
import com.project.service.RetailerService;

@RestController
@CrossOrigin
public class RetailerController {
	
	@Autowired
	private RetailerService retailerService;
	
	@PostMapping(path="/register")
	public Status register(@RequestBody Retailer retailer) {
		try {
			int id = retailerService.register(retailer);
			Status status = new Status();
			status.setId(id);
			status.setStatus(true);
			status.setStatusMessage("Registration Successfull");
			return status;
		}
		catch(RetailerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping(path="/addproduct")
	public Status addProduct(@RequestBody Product product, Retailer retailer) {
		try {
			int id = retailerService.additionOfProduct(product, retailer);
			AddProductStatus status = new AddProductStatus();
			status.setProductId(product.getProductId());
			status.setStatus(true);
			status.setStatusMessage("Product added successfully");
			status.setMsg("Congrats on uploading");
			return status;
		}catch(RetailerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
}
