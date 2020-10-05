package com.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @SequenceGenerator(name = "myseq" , sequenceName = "seq_carpart" , allocationSize =10)
	@Column(name="product_id")
	private int productId;
	
	private String name;
	private double price;
	private int quantity;
	private String category;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="retailer_id")
	private Retailer retailer;
	
	private String brand;
	private String description;
	private String productImage1;
	private String productImage2;
	private String productImage3;
	private String productImage4;
	
	@OneToMany(mappedBy="product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetail;
	
	@OneToMany(mappedBy="product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cart> cart;

	@OneToMany(mappedBy="product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Wishlist> wishlist;


	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public List<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getProductImage1() {
		return productImage1;
	}

	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public String getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
//				+ ", category=" + category + ", retailer=" + retailer + ", brand=" + brand + ", description="
//				+ description + ", productImage1=" + productImage1 + ", productImage2=" + productImage2
//				+ ", productImage3=" + productImage3 + ", productImage4=" + productImage4 + ", orderDetail="
//				+ orderDetail + ", cart=" + cart + ", wishlist=" + wishlist + "]";
//	}
	
     
}
