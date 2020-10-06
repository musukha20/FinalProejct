package com.project.dto;

public class CartDto {

	private int cId;
    private int pId;
    private int qty;
    private String pImage1;
    private String pName;
    private String pBrand;
    private double pPrice;
    private int totalPrice;
	public CartDto(int cId, int pId, int qty, String pImage1, String pName, String pBrand, double pPrice,
			int totalPrice) {
		super();
		this.cId = cId;
		this.pId = pId;
		this.qty = qty;
		this.pImage1 = pImage1;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.totalPrice = totalPrice;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
    
    
}
