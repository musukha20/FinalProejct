package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wish_list")
public class Wishlist {

	@Id
	@GeneratedValue
	private int id;
}
