package com.project.repository;

import com.project.exception.CartException;

public interface CartDao {

	public boolean addToCart(int userId,int productId);

	public boolean updateCart(int cartId, int addOrMinus);

	public boolean deleteCart(int cartId) throws CartException;
	

}
