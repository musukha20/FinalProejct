package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.project.entity.Product;
import com.project.entity.User;
import com.project.entity.Wishlist;
import com.project.exception.WishlistException;


@Repository
public class WishlistDaoImpl implements WishlistDao{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public boolean addToWishlist(int uId, int pId) {
		User user = entityManager.find(User.class, uId);
		Product product = entityManager.find(Product.class, pId);
		Wishlist wishlist = new Wishlist();
		wishlist.setUser(user);
		wishlist.setProduct(product);
		entityManager.persist(wishlist);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteWishlist(int wId) throws WishlistException {
		Wishlist cart = entityManager.find(Wishlist.class, wId);
		entityManager.remove(cart);
		return true;
	}

	
}
