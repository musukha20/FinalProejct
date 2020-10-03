package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.entity.Cart;
import com.project.entity.Product;
import com.project.entity.User;

@Repository
public class CartDaoImpl implements CartDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public boolean addToCart(int userId,int productId)
	{
		User user=this.entityManager.find(User.class, userId);
		Product product=this.entityManager.find(Product.class, productId);
		Cart cart=new Cart();
		cart.setQuantity(1);
		cart.setProduct(product);
		cart.setUser(user);
		this.entityManager.persist(cart);
		return true;
	}
	
	
}
