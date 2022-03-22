package de.lebenshilfe.foodorder.converters;

import de.lebenshilfe.foodorder.enums.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

	@Override
	public String convertToDatabaseColumn(Role role) {
		return role.getName();
	}

	@Override
	public Role convertToEntityAttribute(String dbData) {
		for (Role role : Role.values()) {
            if (role.getName().equals(dbData)) {
                return role;
            }
        }
		
		throw new IllegalArgumentException("Unknown database value: " + dbData);
	}
	
}