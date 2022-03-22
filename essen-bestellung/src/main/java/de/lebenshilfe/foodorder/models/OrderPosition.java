package de.lebenshilfe.foodorder.models;

import java.time.LocalDate;

public class OrderPosition {
	
	private Integer orderPositionId;
	
	private FoodOrder foodOrder;
	
	private String food;
	
	private Double price;
	
	private Integer amount;
	
	private LocalDate foodDate;
	
	private Integer foodId;
	
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