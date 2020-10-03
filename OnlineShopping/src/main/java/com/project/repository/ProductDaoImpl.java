package com.project.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.dto.ProductDto;
import com.project.entity.Product;

public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<ProductDto> search(String keyword) {
		List<ProductDto> products = new ArrayList<ProductDto>();
		String query = "select p.* from Product p where brand =:x or category:=y or name like :=z";
		Query q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", keyword);
		q.setParameter("y", keyword);
		q.setParameter("z", "%"+keyword+"%");
		List<Product> product = q.getResultList();
		for(Product p: product) {
			int productId = p.getProductId();
			String productImage1 = p.getProductImage1();
			String productName = p.getName();
			String productBrand = p.getBrand();
			Double productPrice = p.getPrice();
			String productDescription = p.getDescription();
			String productImage2 = p.getProductImage2();
			String productImage3 = p.getProductImage3();
			String productImage4 = p.getProductImage4();
			products.add(new ProductDto(productImage1, productImage2, productImage3,productImage4,productDescription,
					productId, productName, productBrand,productPrice));
		}
		return products;
	}

}
