package de.lebenshilfe.foodorder.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FoodOrder extends AbstractModel {
	
	@Column
	private LocalDateTime orderDateTime;
	
	@ManyToOne(optional = false)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderPosition> orderPositions;
	
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public User getUser() {
		return user;
	}
	
	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}
	
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setOrderPositions(List<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}
	
}