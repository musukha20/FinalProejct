package com.project.repository;

import com.project.entity.User;

public interface UserDao {
	
	int sava(User user);
	public boolean isUserPresent(String email);

}
