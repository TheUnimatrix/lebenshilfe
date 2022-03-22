package de.lebenshilfe.foodorder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role extends AbstractModel {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer roleId;
	
	@Column(length = 7, unique = true)
	private String name;

//	public Integer getRoleId() {
//		return roleId;
//	}

	public String getName() {
		return name;
	}

//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}

	public void setName(String name) {
		this.name = name;
	}
	
}