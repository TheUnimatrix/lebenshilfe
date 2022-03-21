package de.lebenshilfe_schleiz.foodorder.models;

public class User {
	
	private Long userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Address deliveryAddress;
	
	private Address billingAddress;

	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}