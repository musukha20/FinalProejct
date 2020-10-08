package com.project.repository;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Otp;

@Repository
public class OTPDaoImpl implements OTPDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int addOtp() {
		Otp otpVal = new Otp();
		Random rand = new Random();
		int otp = rand.nextInt(99999);
		otpVal.setOtpValue(otp);
		this.entityManager.persist(otpVal);
		return otp;
	}

	@Override
	public int getLastOTP() {
		
		String q1 = "select max(o.otpId) from Otp a";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number otp = (Number) query1.getSingleResult();
		String q2 = "from Otp where otpId=:x";
		Query query2 = (Query) this.entityManager.createQuery(q2);
		query2.setParameter("x", otp.intValue());
		Otp otpVal = (Otp)query2.getSingleResult();
		//then fetch its value
		System.out.println("Fetched value :"+otpVal.getOtpValue());
		return otpVal.getOtpValue();
	}

}
