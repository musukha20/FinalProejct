package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.entity.Cart;
import com.project.entity.Product;
import com.project.entity.User;
import com.project.exception.CartException;

@Repository
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addToCart(int userId, int productId) {
		User user = this.entityManager.find(User.class, userId);
		Product product =this.entityManager.find(Product.class, productId);
		System.out.println(user);
		System.out.println(product);
		Cart cart = new Cart();
		
		cart.setQuantity(14); // be default we set it to 1
		cart.setUser(user);
		cart.setProduct(product);
		this.entityManager.persist(cart);
		return true;
	}
	
	@Override
	public boolean updateCart(int cartId, int addOrMinus)
	{
		if(addOrMinus==1)
		{
			Cart cart = this.entityManager.find(Cart.class, cartId);
			int productQty = cart.getProduct().getQuantity();
			if(cart.getQuantity()+1 <= productQty)
			{
				//update it!
				int oldQty = cart.getQuantity();
				int newQty = oldQty+1;
				cart.setQuantity(newQty);
				this.entityManager.merge(cart);
				return true;
			}
			return false;
		}
		else
		{
			Cart cart = this.entityManager.find(Cart.class, cartId);
			if(cart.getQuantity()-1 >= 1)
			{
				//update it!
				int oldQty = cart.getQuantity();
				int newQty = oldQty-1;
				cart.setQuantity(newQty);
				this.entityManager.merge(cart);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean deleteCart(int cartId) throws CartException
	{
		Cart cart = this.entityManager.find(Cart.class, cartId);
		this.entityManager.remove(cart);
		return true;
	}



}
