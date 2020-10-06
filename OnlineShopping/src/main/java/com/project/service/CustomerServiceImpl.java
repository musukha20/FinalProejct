package com.project.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CartDto;
import com.project.dto.PlacedOrder;
import com.project.entity.Cart;
import com.project.entity.User;
import com.project.exception.CartException;
import com.project.exception.CustomerServiceException;
import com.project.repository.CartDao;
import com.project.repository.PlaceOrderDao;
import com.project.repository.UserDao;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CartDao cartDao;
	@Autowired
	private PlaceOrderDao placeOrderDao;
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public int register(User user) {
		if(!userDao.isUserPresent(user.getEmail())) {
			int id=userDao.sava(user);
			return id;
		}
		else
			throw new CustomerServiceException("User Already Registered");
	}
	
	
	@Override
	public boolean addToCart(int userId,int productId) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(userId, productId);
        
	}
	
	@Override
	public boolean updateCart(int cId, int addOrMinus) {
		// TODO Auto-generated method stub
		return this.cartDao.updateCart(cId,addOrMinus);
	}
	
	@Override
	public boolean deleteCart(int cartId) throws CartException {
		// TODO Auto-generated method stub
		return this.cartDao.deleteCart(cartId);
	}
	@Override
	public List<CartDto> getCartValues(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.getCartOfUser(userId);
	}





	@Override
	public boolean placeOrder(List<Cart> carts, String payType) {
		// TODO Auto-generated method stub
		return placeOrderDao.placeOrder(carts,payType);
	}


	@Override
	public List<PlacedOrder> getMyPlacedOrders(int uId) {
		// TODO Auto-generated method stub
		return placeOrderDao.showPlacedOrders(uId);
	}
	
	

}
