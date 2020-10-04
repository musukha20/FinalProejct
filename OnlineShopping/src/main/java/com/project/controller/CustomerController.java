package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AddToCartStatus;
import com.project.dto.Status;
import com.project.entity.Cart;
import com.project.exception.CustomerServiceException;
import com.project.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/addToMyCart")
	public Status addToMyCart(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
     System.out.println(userId);
     System.out.println(productId);
		try {
			boolean ok = customerService.addToCart(userId, productId);
			Status s = new Status();
			s.setStatus(true);
			if (ok == true) {
				s.setStatusMessage("Product Added To Cart Successfully");

			} else {
				s.setStatusMessage("Cannot Add Product to Cart");

			}
			return s;

		} catch (CustomerServiceException e) {
			AddToCartStatus s = new AddToCartStatus();
			s.setStatus(false);
			s.setStatusMessage(e.getMessage());
			return s;
		}
	}


	@PostMapping(path = "/placeOrder")
	public String placeOrder(@RequestBody List<Cart> carts, @RequestParam("payType")  String payType) {
		System.out.println("payType");
		boolean ok = customerService.placeOrder(carts, payType);

		if (ok == true)
			return "Order Place Successfully";
		return "Order place failed";

	}
}
