package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.CartDao;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CartDao cartDao;
	
	public boolean addToCart(int userId,int productId) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(userId, productId);
        
	}

}
