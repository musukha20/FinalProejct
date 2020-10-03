package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Status;
import com.project.entity.Cart;
import com.project.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path="/addToMyCart/{userId}/{productId}")
	public Status addToMyCart(@PathVariable String userId,@PathVariable String productId )
	{
		Status status = new Status();
		return status;
	}
	
	@PostMapping(path="/placeOrder")
	public String placeOrder(@RequestBody List<Cart> carts , @RequestBody String payType) {
		boolean ok=customerService.placeOrder(carts, payType);
		
		if(ok==true)
			return "Order Place Successfully";
		return "Order place failed";
		
	}
}
