package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AdminLoginStatus;
import com.project.dto.Login;
import com.project.dto.LoginStatus;
import com.project.entity.Admin;
import com.project.exception.CustomerServiceException;
import com.project.service.AdminService;

@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/adminlogin")
    //@PostMapping(path="/login", consumes ="application/json")
    public AdminLoginStatus login(@RequestBody Login login) {
        try {
        	//System.out.println(loginDto.getEmail());
            Admin admin = adminService.login(login.getEmail(), login.getPassword());
            AdminLoginStatus adminloginStatus = new AdminLoginStatus();
            adminloginStatus.setStatus(true);
            adminloginStatus.setStatusMessage("Login Sucessful");
            adminloginStatus.setAdminId(admin.getId());
            adminloginStatus.setAdminName(admin.getName());
            return adminloginStatus;
            
        }
        catch(CustomerServiceException e) {
            AdminLoginStatus adminloginStatus = new AdminLoginStatus();
            adminloginStatus.setStatusMessage(e.getMessage());
            return adminloginStatus;
        }
        
    }
}
