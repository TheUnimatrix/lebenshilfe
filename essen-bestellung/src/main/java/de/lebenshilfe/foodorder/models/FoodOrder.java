package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodOrder extends AbstractModel {
	
	@Column
	private LocalDateTime orderDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private User user;
	
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public User getUser() {
		return user;
	}
	
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}