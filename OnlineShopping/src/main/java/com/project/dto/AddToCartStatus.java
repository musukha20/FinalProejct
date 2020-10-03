package com.project.dto;

public class AddToCartStatus extends Status {

	public int cartId;
	public String alert;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	
}
