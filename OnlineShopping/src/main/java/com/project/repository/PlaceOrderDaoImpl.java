package com.project.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.project.dto.PlacedOrder;
import com.project.entity.Cart;
import com.project.entity.Order;
import com.project.entity.OrderDetail;
import com.project.entity.Payment;
import com.project.entity.Product;
import com.project.entity.User;


@Repository
public class PlaceOrderDaoImpl implements PlaceOrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean placeOrder(List<Cart> carts, String payType) {
		// TODO Auto-generated method stub
		
		List<OrderDetail> orderDetailsList=new ArrayList<OrderDetail>();
		Cart cart=entityManager.find(Cart.class, carts.get(0).getId());
		
		//first get userTable from a specific Cart
		User user=cart.getUser();
		
		Order newOrder= new Order();
		newOrder.setUser(user);
		entityManager.persist(newOrder);   //save the new order to get the id
		
		
		for(Cart c : carts) {
			
			cart=entityManager.find(Cart.class, c.getId());
			
			OrderDetail orderDetails =new OrderDetail();
			orderDetails.setPurchaseDate(LocalDate.now());
			orderDetails.setQuantity(cart.getProduct().getQuantity());
			orderDetails.setPrice(cart.getProduct().getPrice());
			orderDetails.setOrder(newOrder);
			orderDetails.setProduct(c.getProduct());
			
			entityManager.persist(orderDetails);  //adding new orderDetails
			
			orderDetailsList.add(orderDetails);	  //storing it to the list
			
			
			//Now updating the quantity of product table
			
			Product product=cart.getProduct();
			int actualProductQty=product.getQuantity();
			int productQty=actualProductQty-cart.getQuantity();
			
			product.setQuantity(productQty);
			
			entityManager.merge(product);    //updating the quantity of product
			entityManager.remove(cart);      //removing this item of the cart
		}
			
		Payment newPayment=new Payment();
		newPayment.setPaymentType(payType);
		
		entityManager.persist(newPayment);   //adding payment type
		newOrder.setPayment(newPayment);
		
		entityManager.merge(newOrder);   //update order table
		
		return true;
	}

	@Override
	public List<PlacedOrder> showPlacedOrders(int uId) {
		// TODO Auto-generated method stub
		
		String pType = "";
		List<PlacedOrder> orders = new ArrayList<PlacedOrder>();
		User user = this.entityManager.find(User.class, uId);
		String q = "from Order where user=:x";
		return null;
	}
	

}
