package com.project.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.dto.CartDto;
import com.project.dto.PlacedOrder;
import com.project.entity.Cart;
import com.project.entity.Order;
import com.project.entity.OrderDetail;
import com.project.entity.Payment;
import com.project.entity.Product;
import com.project.entity.User;
import com.project.exception.CustomerServiceException;


@Repository
public class PlaceOrderDaoImpl implements PlaceOrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean placeOrder(List<CartDto> carts, String payType) {
		// TODO Auto-generated method stub
		
		List<OrderDetail> orderDetailsList=new ArrayList<OrderDetail>();
		Cart cart=entityManager.find(Cart.class, carts.get(0).getcId());
		
		//first get userTable from a specific Cart
		User user=cart.getUser();
		
		Order newOrder= new Order();
		newOrder.setUser(user);
		entityManager.persist(newOrder);   //save the new order to get the id
		
		
		for(CartDto c : carts) {
			
			cart=entityManager.find(Cart.class, c.getcId());
			
			OrderDetail orderDetails =new OrderDetail();
			orderDetails.setPurchaseDate(LocalDate.now());
			orderDetails.setQuantity(cart.getQuantity());
			orderDetails.setPrice(cart.getProduct().getPrice());
			orderDetails.setOrder(newOrder);
			orderDetails.setProduct(cart.getProduct());
			
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
		User user = entityManager.find(User.class, uId);
		String q = "from Order where user=:x";
		Query query=entityManager.createQuery(q);
		query.setParameter("x", user);
		List<Order> myOrders=query.getResultList();
		
		if(myOrders.size()!=0) {
			pType=myOrders.get(0).getPayment().getPaymentType();
		}
		
		for(Order oye : myOrders) {
			q="from OrderDetail where order=:y";
			query=entityManager.createQuery(q);
			query.setParameter("y",oye);
			List<OrderDetail> orderDetails=query.getResultList();
			
			for(OrderDetail o : orderDetails) {
				int pId=o.getProduct().getProductId();
				String pName=o.getProduct().getName();
				String pImage=o.getProduct().getProductImage1();
				double pPrice=o.getPrice();
				String pBrand=o.getProduct().getBrand();
				int pQty=o.getQuantity();
				String pOrderDate=o.getPurchaseDate().toString();
				orders.add(new PlacedOrder(pId, pImage, pBrand, pPrice, pOrderDate, pQty, pType, pName));
			}
			
			
		}
		
		return orders;
	}
	
	
}
