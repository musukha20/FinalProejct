package com.project.repository;

import java.util.List;

import com.project.dto.CartDto;
import com.project.dto.PlacedOrder;
import com.project.entity.Cart;

public interface PlaceOrderDao {
	
	public boolean placeOrder(List<CartDto> carts, String payType);
	public List<PlacedOrder> showPlacedOrders(int uId);
}
