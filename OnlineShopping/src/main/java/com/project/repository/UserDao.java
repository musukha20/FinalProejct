package com.project.repository;

import java.util.List;

import com.project.entity.Cart;
import com.project.entity.User;

public interface UserDao {
	
	int sava(User user);
	public boolean isUserPresent(String email);
	public List<Cart> getCartOfUser(int uId);

}
