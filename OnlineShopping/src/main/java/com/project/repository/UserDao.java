package com.project.repository;

import java.util.List;

import com.project.dto.CartDto;
import com.project.dto.WishListDto;
import com.project.entity.User;

public interface UserDao {
	
	int sava(User user);
	public boolean isUserPresent(String email);

	public List<CartDto> getCartOfUser(int uId);

	
	int findByEmailPassword(String email, String password);
	User findById(int id);
	
	public List<WishListDto> getWishlistOfUser(int uId);

	public User getUserByEmail(String email);
	
	public User updateUser(long uId, User user);

}
