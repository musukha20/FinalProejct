package com.project.entity;

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
@Table(name= "retailer")
public class Retailer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @SequenceGenerator(name = "myseq" , sequenceName = "seq_carpart" , allocationSize =10)
	@Column(name="retailer_id")
	private int id;
	//Hey Samyak was here.
	private String name;
	private String address;
	private String email;
	
	@Column(name="phone_no")
	
	private int phoneNo;
	private String password;
	
	@ManyToOne( cascade = CascadeType.MERGE)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	@OneToMany(mappedBy="retailer")
	private List<Product> product;
	
	@OneToMany(mappedBy="retailer", cascade=CascadeType.MERGE)
	private List<Stock> stock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
