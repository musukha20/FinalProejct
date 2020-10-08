package com.project.repository;

import com.project.entity.Admin;

public interface AdminDao {

	int findByEmailPassword(String email, String password);
	public Admin findById(int id);

}