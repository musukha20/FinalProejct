package com.project.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public int findByEmailPassword(String email, String password) {
		return (Integer) entityManager
				.createQuery("select a.id from Admin a where a.email = :em and a.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
					//System.out.println(id);
					return entityManager.find(Admin.class,id);
				}	
}
