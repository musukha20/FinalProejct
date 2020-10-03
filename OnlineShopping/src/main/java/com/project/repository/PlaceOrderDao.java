package com.project.repository;

import java.util.List;

import com.project.entity.Cart;

public interface PlaceOrderDao {
	
	public boolean placeOrder(List<Cart> carts, String payType);


}
