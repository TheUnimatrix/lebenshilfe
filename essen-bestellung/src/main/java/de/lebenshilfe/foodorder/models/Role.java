package de.lebenshilfe.foodorder.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(length = 7)
	private String name;

	public Integer getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}