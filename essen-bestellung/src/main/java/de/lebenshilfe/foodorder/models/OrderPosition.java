package de.lebenshilfe.foodorder.models;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderPosition implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private FoodOrder foodOrder;
	
	private int position;
	
	private char food;
	
	private double price;
	
	private int amount;
	
	private int day;
	
	private int foodId;
	
	private LocalDate foodDate;

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public int getPosition() {
		return position;
	}

	public char getFood() {
		return food;
	}

	public double getPrice() {
		return price;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setFood(char food) {
		this.food = food;
	}
	
	public LocalDate getFoodDate() {
		return foodDate;
	}

	public void setFoodDate(LocalDate foodDate) {
		this.foodDate = foodDate;
	}

	public void setPrice(double price) {
		this.price = price;
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