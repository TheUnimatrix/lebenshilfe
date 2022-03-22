package de.lebenshilfe.foodorder.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderPositionId;
	
	@Column
	private String food;
	
	@Column
	private Double price;
	
	@Column
	private Integer amount;
	
	@Column
	private LocalDate foodDate;
	
	@Column
	private Integer foodId;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private FoodOrder foodOrder;
	
	public Integer getOrderPositionId() {
		return orderPositionId;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public String getFood() {
		return food;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getAmount() {
		return amount;
	}

	public LocalDate getFoodDate() {
		return foodDate;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setOrderPositionId(Integer orderPositionId) {
		this.orderPositionId = orderPositionId;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setFoodDate(LocalDate foodDate) {
		this.foodDate = foodDate;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	
}