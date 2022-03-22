package de.lebenshilfe.foodorder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//@Entity
public enum Role {//extends AbstractModel {
	
//	@Column(length = 7, unique = true)
//	private String name;
	
//	public String getName() {
//		return name;
//	}

//	public void setName(String name) {
//		this.name = name;
//	}
	
	USER("USER"),
	MANAGER("MANAGER"),
	ADMIN("ADMIN");
	
	private String name;
	
	private Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}