package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodOrder extends AbstractModel {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer orderId;
	
	@Column
	private LocalDateTime orderDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private User user;
	
//	public Integer getOrderId() {
//		return orderId;
//	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public User getUser() {
		return user;
	}

//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}