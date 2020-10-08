package com.project.repository;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.project.dto.CartDto;
import com.project.dto.WishListDto;
import com.project.entity.Cart;
import com.project.entity.User;
import com.project.entity.Wishlist;

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
	public List<CartDto> getCartOfUser(int userId) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		List<CartDto> carts = new ArrayList<CartDto>();
		User user = (User)this.entityManager.find(User.class, userId);
		System.out.println("User is :"+user);
		String q = "from Cart where user=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", user);
		List<Cart> cartTables = query.getResultList();
		//System.out.println("Cart values are :"+query.getResultList().toString());
		for(Cart c : cartTables)
		{
			int cId = c.getId();
			int pId = c.getProduct().getProductId();
			int cQty = c.getProduct().getQuantity()>=c.getQuantity() ? c.getQuantity() : 0;
			String pName = c.getProduct().getName();
			String pBrand = c.getProduct().getBrand();
			double pPrice = c.getProduct().getPrice();
			totalPrice += pPrice*cQty;
			String pImage1 = c.getProduct().getProductImage1();
			carts.add(new CartDto(cId, pId, cQty, pImage1, pName, pBrand,pPrice,totalPrice));
			
			
			
		}
		return carts;
	}


	@Override
	public int findByEmailPassword(String email, String password) {
		return (Integer) entityManager
				.createQuery("select c.id from User c where c.email = :em and c.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
					//System.out.println(id);
					return entityManager.find(User.class,id);
				}

	@Override
	public List<WishListDto> getWishlistOfUser(int uId) {
		
		List<WishListDto> wishlists = new ArrayList<WishListDto>();
		User user = (User)this.entityManager.find(User.class, uId);
		System.out.println("User is :"+user);
		String q = "from Wishlist where user=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", user);
		List<Wishlist> wishlist = query.getResultList();
		//System.out.println("Cart values are :"+query.getResultList().toString());
		for(Wishlist w : wishlist)
		{
			int wId = w.getId();
			int pId = w.getProduct().getProductId();
			String pName = w.getProduct().getName();
			String pBrand = w.getProduct().getBrand();
			int pPrice = (int) w.getProduct().getPrice();
			String pImage1 = w.getProduct().getProductImage1();
			wishlists.add(new WishListDto(wId, pId, pImage1, pName, pBrand, pPrice));
		}
		return wishlists;
	}	
}
