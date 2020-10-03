package com.project.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.entity.Product;

public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<Product> search(String keyword) {
		List<Product> products = new ArrayList<Product>();
		String query = "select p.* from Product p where brand =:x or category:=y or name like :=z";
		Query q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", keyword);
		q.setParameter("y", keyword);
		q.setParameter("z", "%"+keyword+"%");
		return products;
	}

}
