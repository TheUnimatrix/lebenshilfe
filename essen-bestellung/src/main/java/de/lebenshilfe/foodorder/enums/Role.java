package de.lebenshilfe.foodorder.enums;

public enum Role {
	
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