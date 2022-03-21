package de.lebenshilfe_schleiz.foodorder.models;

import java.util.Date;

public class FoodOrder {
	
	private Long orderId;
	
	private Date orderDate;
	
	private User user;

	public Long getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}