package com.project.repository;

import java.util.List;

import com.project.dto.CartDto;
import com.project.entity.Cart;
import com.project.entity.User;

public interface UserDao {
	
	int sava(User user);
	public boolean isUserPresent(String email);
<<<<<<< HEAD
	public List<CartDto> getCartOfUser(int uId);
=======
	public List<Cart> getCartOfUser(int uId);
	int findByEmailPassword(String email, String password);
	User findById(int id);
>>>>>>> branch 'master' of https://github.com/musukha20/FinalProject.git

}
