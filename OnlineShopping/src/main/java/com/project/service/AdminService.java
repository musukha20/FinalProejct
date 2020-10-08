package com.project.service;

import com.project.entity.Admin;


public interface AdminService {

	Admin login(String email, String password);

}