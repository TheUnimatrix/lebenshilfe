package de.lebenshilfe_schleiz.foodorder.models;

public class Address {
	
	private Integer addressId;
	
	private String street;
	
	private String postalCode;
	
	private String city;

	public Integer getAddressId() {
		return addressId;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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