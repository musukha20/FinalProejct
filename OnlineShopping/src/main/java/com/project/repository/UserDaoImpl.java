package com.project.repository;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.project.entity.Cart;
import com.project.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public int sava(User user) {
		// TODO Auto-generated method stub
		User updatedUser=entityManager.merge(user);
		return updatedUser.getId();
		
	}

	@Override
	public boolean isUserPresent(String email) {
		return (Long) entityManager.createQuery("select count(u.id) from User u where u.email =: em").setParameter("em",email)
				.getSingleResult() ==1 ? true :false;
	}

	@Override
	public List<Cart> getCartOfUser(int uId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	

}
