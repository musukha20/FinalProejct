package com.project.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.dto.CartDto;
import com.project.dto.ForgotPassword;
import com.project.dto.PlacedOrder;
import com.project.dto.WishListDto;
import com.project.entity.Cart;
import com.project.entity.Otp;
import com.project.entity.User;
import com.project.exception.CartException;
import com.project.exception.CustomerServiceException;
import com.project.exception.WishlistException;
import com.project.repository.CartDao;
import com.project.repository.OTPDao;
import com.project.repository.PlaceOrderDao;
import com.project.repository.UserDao;
import com.project.repository.WishlistDao;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CartDao cartDao;
	@Autowired
	private PlaceOrderDao placeOrderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OTPDao otpDAO;
	@Autowired
	private WishlistDao wishListDao;
	
	public int generateOTP()
	{
		return this.otpDAO.addOtp();
	}
	
	public boolean forgotPassword(ForgotPassword forgotPassword) {
		// TODO Auto-generated method stub
		//Logic:- first generate new otp, then check if what user put is same then update
		int otp = this.otpDAO.getLastOTP();
		if(Integer.parseInt(forgotPassword.getOtp())==otp)
		{
			System.out.println("OTP Matched!");
			User user = (User)this.userDao.getUserByEmail(forgotPassword.getEmail());
			user.setPassword(forgotPassword.getPassword());
			this.userDao.updateUser(user.getId(), user);
			return true;
		}
		return false;
	} 
	
	
	@Override
	public int register(User user) {
		if(!userDao.isUserPresent(user.getEmail())) {
			int id=userDao.sava(user);
			return id;
		}
		else
			throw new CustomerServiceException("User Already Registered");
	}
	
	
	@Override
	public boolean addToCart(int userId,int productId) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(userId, productId);
        
	}
	
	@Override
	public boolean updateCart(int cId, int addOrMinus) {
		// TODO Auto-generated method stub
		return this.cartDao.updateCart(cId,addOrMinus);
	}
	
	@Override
	public boolean deleteCart(int cartId) throws CartException {
		// TODO Auto-generated method stub
		return this.cartDao.deleteCart(cartId);
	}
	@Override
	public List<CartDto> getCartValues(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.getCartOfUser(userId);
	}



	@Override
	public boolean placeOrder(List<CartDto> carts, String payType) {
		// TODO Auto-generated method stub
		return placeOrderDao.placeOrder(carts,payType);
	}


	@Override
	public List<PlacedOrder> getMyPlacedOrders(int uId) {
		// TODO Auto-generated method stub
		return placeOrderDao.showPlacedOrders(uId);
	}


	@Override
	public User login(String email, String password) {
		try {
            int id = userDao.findByEmailPassword(email, password);
            User student = userDao.findById(id);
            return student;
        }
        catch(EmptyResultDataAccessException e) {
            throw new CustomerServiceException("Cannot Login.Incorrect eamil/password");
            
        }
    }


	@Override
	public List<WishListDto> getWishlistValues(int uId) {
		// TODO Auto-generated method stub
		return this.userDao.getWishlistOfUser(uId);
	}


	@Override
	public boolean deleteWishlist(int wId) throws WishlistException {
		// TODO Auto-generated method stub
		return this.wishListDao.deleteWishlist(wId);
	}

	@Override
	public boolean addToWishlist(int uId, int pId) {
		// TODO Auto-generated method stub
		return this.wishListDao.addToWishlist(uId, pId);
	}

	
}
