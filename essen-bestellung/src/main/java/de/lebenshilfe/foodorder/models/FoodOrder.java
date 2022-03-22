package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column
	private LocalDateTime orderDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
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