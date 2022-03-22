package de.lebenshilfe.foodorder.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@JoinColumn(name = "role")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Role role;
	
	@JoinColumn(name = "deliveryAddress")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Address deliveryAddress;
	
	@JoinColumn(name = "billingAddress")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Address billingAddress;

	public Integer getUserId() {
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
	
	public Role getRole() {
		return role;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setUserId(Integer userId) {
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