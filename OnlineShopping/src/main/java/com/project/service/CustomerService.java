package com.project.service;

import com.project.entity.Cart;
import com.project.entity.Payment;


public interface CustomerService {

	public boolean addToCart(int userId, int productId);
	public boolean placeOrder(Cart cart, Payment payment);
}
