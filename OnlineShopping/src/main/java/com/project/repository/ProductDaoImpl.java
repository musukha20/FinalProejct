package com.project.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.ProductDto;
import com.project.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<ProductDto> search(String keyword) {
		List<ProductDto> products = new ArrayList<ProductDto>();
		String query = "from Product where brand =:x or category  =:x or name like :y";
		Query q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", keyword);
		q.setParameter("y", "%"+keyword+"%");
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
					productId, productName, productBrand, productPrice));
		}
		return products;
	}
	
	public List<ProductDto> sortProductByFactors(String by , boolean order ){
		//true value is for ascending and false value is for descending
		List<ProductDto> products = new ArrayList<ProductDto>();
		Query q = null;
		if(order == true && by.equalsIgnoreCase("price")) {
			String commonQuery = "from Product p order by p.price asc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order == false && by.equalsIgnoreCase("price")) {
			String commonQuery = "from Product p order by p.price desc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order == true && by.equalsIgnoreCase("brand")) {
			String commonQuery = "from Product p order by p.brand asc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order == false && by.equalsIgnoreCase("brand")) {
			String commonQuery = "from Product p order by p.brand desc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}
		/*else if(order == true && by.equalsIgnoreCase("category")) {
			String commonQuery = "from Product p order by p.category asc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}
		else if(order == false && by.equalsIgnoreCase("category")) {
			String commonQuery = "from Product p order by p.category desc";
			q = (Query)this.entityManager.createQuery(commonQuery);
		}*/
		List<Product> productentity = q.getResultList();
		for(Product p : productentity) {
			int productId = p.getProductId();
			String productName = p.getName();
			String productBrand = p.getBrand();
			Double productPrice = p.getPrice();
			String productDescription = p.getDescription();
			String productImage1 = p.getProductImage1();
			String productImage2 = p.getProductImage2();
			String productImage3 = p.getProductImage3();
			String productImage4 = p.getProductImage4();
			products.add(new ProductDto(productImage1, productImage2, productImage3,productImage4,productDescription,
					productId, productName, productBrand,productPrice));
		}
		return products;
	}
	public ProductDto getProductById(int productId) {         // should be based only on ID. (ngFor)
		ProductDto product = null;
		String q = "select name,price,brand,description,productImage1,productImage2,productImage3,productImage4 from ProductDto where productId=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", productId);
		List<Object[]> prod = query.getResultList();
		for(Object[] p :prod) {
			String productImage1 = (String)p[0];
			String productImage2 = (String)p[1];
			String productImage3 = (String)p[2];
			String productImage4 = (String)p[3];
			String description = (String)p[4];
			String brand = (String)p[5];
			Double price = (Double)p[6];
			String name = (String)p[7];
			product = new ProductDto(productImage1,productImage2,productImage3,productImage4,description,productId,name,brand,price);
		}
		return product;
	}

	
 
}
