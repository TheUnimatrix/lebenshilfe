package de.lebenshilfe.foodorder.daos;

import de.lebenshilfe.foodorder.models.Role;

public class RoleDao extends AbstractDao<Role> {
	
	/*
	public void saveOrUpdateRole(Role role) {
		if (role != null) {
			
			Integer roleId = role.getId();
//			System.out.println(addressId);
			
			if (roleId == null) {
				super.saveObject(role);
			} else {
				super.updateObject(role);
			}
		}
	}
	
	public Role getRoleById(Integer roleId) {
		Role role = null;
		
		if (roleId != null) {
			role = super.getObjectById(Role.class, roleId);
		}
		
		return role;
	}
	*/
}