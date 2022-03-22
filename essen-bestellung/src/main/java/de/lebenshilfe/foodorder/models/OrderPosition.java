package de.lebenshilfe.foodorder.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderPosition extends AbstractModel {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer orderPositionId;
	
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
	
//	public Integer getOrderPositionId() {
//		return orderPositionId;
//	}

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

//	public void setOrderPositionId(Integer orderPositionId) {
//		this.orderPositionId = orderPositionId;
//	}

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