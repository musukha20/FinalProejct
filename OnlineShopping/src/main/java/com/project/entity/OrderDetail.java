package com.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {
	
	@Id
	@GeneratedValue
	@Column(name="order_detail_id")
	private int orderDetaiId;
	private double price;
	
	@Column(name="purchase_date")
	private LocalDate purchaseDate;
	private int quantity;
	public int getOrderDetaiId() {
		return orderDetaiId;
	}
	public void setOrderDetaiId(int orderDetaiId) {
		this.orderDetaiId = orderDetaiId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
