package de.lebenshilfe.foodorder.models;

import de.lebenshilfe.foodorder.converters.RoleConverter;
import de.lebenshilfe.foodorder.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class User extends AbstractModel {
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 60)
	private String password;
	
	@Convert(converter = RoleConverter.class)
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Address deliveryAddress;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Address billingAddress;
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public Role getRole() {
		return role;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
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
	
	public void setRole(Role role) {
		this.role = role;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}