package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Status;
import com.project.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path="/addToMyCart/{userId}/{productId}")
	public Status addToMyCart(@PathVariable String userId,@PathVariable String productId )
	{
		
	}
	
}
