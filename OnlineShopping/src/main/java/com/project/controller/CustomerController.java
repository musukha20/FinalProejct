package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.dto.AddToCartStatus;
import com.project.dto.PlacedOrder;
import com.project.dto.Status;
import com.project.entity.Cart;
import com.project.entity.Temp;
import com.project.entity.User;
import com.project.exception.CustomerServiceException;
import com.project.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path="/userRegistration")
	public Status register(@RequestBody User user) {
		try {
			int id=customerService.register(user);
			Status status=new Status();
			status.setId(id);
			status.setStatus(true);
			status.setStatusMessage("Registration Successfull");
			return status;
			
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	

	@GetMapping(path = "/addToMyCart")
	public Status addToMyCart(@RequestParam("userId") int userId, @RequestParam("productId") int productId) {
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
	
	@GetMapping(path = "/updateMyCart") //passed
	public String updateMyCart(@RequestParam("cartId") int cartId, @RequestParam("addOrMinus") int addOrMinus)
	{
		boolean ok = this.customerService.updateCart(cartId,addOrMinus);
		if(ok==true)
			return "Cart Updated Successful";
		return "Cannot Update Cart";
	}
	
	@DeleteMapping(path = "/deleteMyCart") //passed
	public String deleteMyCart(@RequestParam("cartId")int cId)
	{
		try
		{
			boolean ok = this.customerService.deleteCart(cId);
			return "Cart Deleted";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}



	@PostMapping(path = "/placeOrder")
	public String placeOrder(@RequestBody List<Cart> carts,@RequestParam("payType") String payType) {
	
		try {
		boolean ok = customerService.placeOrder(carts, payType);
		if (ok == true)
			return "Order Place Successfully";
		return "Order place failed";
		}catch(CustomerServiceException e){
		return "Everything Failed";
		}

	} 
	
	

		
	
	@GetMapping(path="/getMyPlacedOrders")
	public List<PlacedOrder> showOrderDetails(@RequestParam ("uId") int uId){
		return customerService.getMyPlacedOrders(uId);
		
	}
}