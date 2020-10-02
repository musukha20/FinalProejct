package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	
	
	

}
