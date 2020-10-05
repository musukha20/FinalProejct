package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.entity.Cart;
import com.project.entity.Product;
import com.project.entity.User;

@Repository
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addToCart(int userId, int productId) {
		System.out.println(userId);
		System.out.println(productId);
		User user = this.entityManager.find(User.class, userId);
		Product product =this.entityManager.find(Product.class, productId);
		System.out.println(user);
		System.out.println(product);
		Cart cart = new Cart();
		
		cart.setQuantity(18); // be default we set it to 1
		cart.setUser(user);
		cart.setProduct(product);
		this.entityManager.persist(cart);
		return true;
	}

}
