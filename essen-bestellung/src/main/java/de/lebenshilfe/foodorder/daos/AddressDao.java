package de.lebenshilfe.foodorder.daos;

import de.lebenshilfe.foodorder.models.Address;

public class AddressDao extends AbstractDao<Address> {

	public void saveOrUpdateAddress(Address address) {
		if (address != null) {
			
			Integer addressId = address.getId();
//			System.out.println(addressId);
			
			if (addressId == null) {
				super.saveObject(address);
			} else {
				super.updateObject(address);
			}
		}
	}
	
	public Address getAddressById(Integer addressId) {
		Address address = null;
		
		if (addressId != null) {
			address = super.getObjectById(Address.class, addressId);
		}
		
		return address;
	}

}