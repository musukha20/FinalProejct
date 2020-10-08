package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Admin;
import com.project.exception.CustomerServiceException;
import com.project.repository.AdminDao;


@Transactional
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin login(String email, String password) {
		try {
            int id = adminDao.findByEmailPassword(email, password);
            Admin student = adminDao.findById(id);
            return student;
        }
        catch(EmptyResultDataAccessException e) {
            throw new CustomerServiceException("Cannot Login.Incorrect email/password");
            
        }
    }
}
