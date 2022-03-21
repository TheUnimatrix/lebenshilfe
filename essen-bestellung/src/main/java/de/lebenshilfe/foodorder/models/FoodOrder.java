package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;

public class FoodOrder {
	
	private Integer orderId;
	
	private LocalDateTime orderDateTime;
	
	private User user;
	
	public Integer getOrderId() {
		return orderId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}