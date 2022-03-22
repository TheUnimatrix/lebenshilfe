package de.lebenshilfe.foodorder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address extends AbstractModel {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer addressId;
	
	@Column
	private String street;
	
	@Column
	private String postalCode;
	
	@Column
	private String city;

//	public Integer getAddressId() {
//		return addressId;
//	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

//	public void setAddressId(Integer addressId) {
//		this.addressId = addressId;
//	}

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