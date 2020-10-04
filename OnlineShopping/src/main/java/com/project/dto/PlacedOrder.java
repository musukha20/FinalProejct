package com.project.dto;

public class PlacedOrder {
	private int pId;
	private String pImage;
	private String pBrand;
	private double pPrice;
	private String pOrderDate;
	private int pQty;
	private String pType;
	private String pName;
	public PlacedOrder(int pId, String pImage, String pBrand, double pPrice, String pOrderDate, int pQty, String pType,
			String pName) {
		super();
		this.pId = pId;
		this.pImage = pImage;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.pOrderDate = pOrderDate;
		this.pQty = pQty;
		this.pType = pType;
		this.pName = pName;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
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
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpOrderDate() {
		return pOrderDate;
	}
	public void setpOrderDate(String pOrderDate) {
		this.pOrderDate = pOrderDate;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	

}
