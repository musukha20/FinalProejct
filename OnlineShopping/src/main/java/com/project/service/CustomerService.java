package com.project.service;
import java.util.List;

import com.project.dto.PlacedOrder;
import com.project.entity.Cart;
import com.project.entity.User;



public interface CustomerService {

	public int register(User user);
	public boolean addToCart(int userId, int productId);
	public boolean placeOrder(List<Cart> carts, String payType);
	public List<PlacedOrder> getMyPlacedOrders(int uId);
}
