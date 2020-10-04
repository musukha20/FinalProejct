package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Cart;
import com.project.entity.Payment;
import com.project.repository.CartDao;
import com.project.repository.PlaceOrderDao;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CartDao cartDao;
	@Autowired
	private PlaceOrderDao placeOrderDao;
	
	@Override
	public boolean addToCart(int userId,int productId) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(userId, productId);
        
	}


	@Override
	public boolean placeOrder(Cart cart, Payment payment) {
		// TODO Auto-generated method stub
		return placeOrderDao.placeOrder(cart.getId(), payment.getPaymentType());
	}

}
