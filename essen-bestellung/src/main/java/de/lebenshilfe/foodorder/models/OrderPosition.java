package de.lebenshilfe.foodorder.models;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderPosition implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private Integer orderPositionId;
	
	public Integer getOrderPositionId() {
		return orderPositionId;
	}
	
	public void setOrderPositionId(Integer orderPositionId) {
		this.orderPositionId = orderPositionId;
	}

	private FoodOrder foodOrder;
	
	private int position;
	
	private String food;
	
	private double price;
	
	private int amount;
	
	private LocalDate foodDate;
	
	private int day;
	
	private int foodId;
	
	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public int getPosition() {
		return position;
	}

	public String getFood() {
		return food;
	}

	public double getPrice() {
		return price;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public LocalDate getFoodDate() {
		return foodDate;
	}
	
	public int getFoodId() {
		return foodId;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setFoodDate(LocalDate foodDate) {
		this.foodDate = foodDate;
	}
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}