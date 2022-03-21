package de.lebenshilfe_schleiz.foodorder.models;

import java.io.Serializable;

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

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*
		// Überprüfe, ob Objekt vom Typ dieser Klasse ist
		if (!(obj instanceof OrderPosition))
			return false;
		
		OrderPosition op = (OrderPosition)obj;
		
		// Objekte stimmen überein, wenn die Schlüssel passen
		return op.getPosition() == this.getPosition()
				&& op.getFoodOrder().getOrderId() == this.getFoodOrder().getOrderId();
		//*/
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}