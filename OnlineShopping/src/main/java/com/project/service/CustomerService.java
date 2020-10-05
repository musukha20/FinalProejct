package com.project.service;
import java.util.List;

import com.project.dto.PlacedOrder;
import com.project.entity.Cart;
import com.project.entity.User;
import com.project.exception.CartException;



public interface CustomerService {

	public int register(User user);
	public boolean addToCart(int userId, int productId);
	public boolean placeOrder(List<Cart> carts, String payType);
	public List<PlacedOrder> getMyPlacedOrders(int uId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cartId) throws CartException;
	
}
