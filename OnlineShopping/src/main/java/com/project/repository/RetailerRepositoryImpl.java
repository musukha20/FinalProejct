package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Retailer;

@Repository
public class RetailerRepositoryImpl implements RetailerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public int save(Retailer retailer) {
		Retailer updatedRetailer = (Retailer) entityManager.merge(retailer);
		return updatedRetailer.getId();
	}
	
	@Override
	public Retailer findById(int id) {
		return entityManager.find(Retailer.class,id);
	}
	
	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (Integer) entityManager.createQuery("select r.id from Retailer r where r.email =:em and r.password =:pw")
				.setParameter("em", email).setParameter("pw", password).getSingleResult();
	}
	
	@Override
	public boolean isRetailerPresent(String email) {
		return (Long) entityManager.createQuery("select count(r.id) from Retailer r where r.email =: em").setParameter("em",email)
				.getSingleResult() ==1 ? true :false;
	}
	
	

}
