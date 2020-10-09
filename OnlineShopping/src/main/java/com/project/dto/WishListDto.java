package com.project.dto;

public class WishListDto {
	private int wId;
	private int pId;
	private String pImage1;
	private String pName;
	private String pBrand;
	private int pPrice;
	
	
	public WishListDto(int wId, int pId, String pImage1, String pName, String pBrand, int pPrice) {
		super();
		this.wId = wId;
		this.pId = pId;
		this.pImage1 = pImage1;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
	}
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
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
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
}
