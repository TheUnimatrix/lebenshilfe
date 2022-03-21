package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;

public class FoodOrder {
	
	private Long orderId;
	
	private LocalDateTime orderDateTime;
	
	private User user;
	
	public Long getOrderId() {
		return orderId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}