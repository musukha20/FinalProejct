package com.project.repository;

import com.project.entity.Admin;

public interface RetailerDao {

	int findByEmailPassword(String email, String password);

	Admin findById(int id);

}