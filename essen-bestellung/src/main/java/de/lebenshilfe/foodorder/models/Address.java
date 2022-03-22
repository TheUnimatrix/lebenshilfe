package de.lebenshilfe.foodorder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Address extends AbstractModel {
	
	@Column
	private String street;
	
	@Column
	private String postalCode;
	
	@Column
	private String city;
	
	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}