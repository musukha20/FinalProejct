package com.project.entity;

import java.util.List;

public class Temp {
	
	private List<Cart> carts;
	private String payType;
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

}
