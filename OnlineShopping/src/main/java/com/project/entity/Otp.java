package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class Otp {

	@Id
	@GeneratedValue
	private int otpId;
	
	private int otpValue;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public int getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(int otpValue) {
		this.otpValue = otpValue;
	}
	
	
}
