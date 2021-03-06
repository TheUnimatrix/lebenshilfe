package de.lebenshilfe.foodorder.daos;

import de.lebenshilfe.foodorder.models.OrderPosition;

public class OrderPositionDao extends AbstractDao<OrderPosition> {
	
	public void saveOrUpdateOrderPosition(OrderPosition orderPosition) {
		if (orderPosition != null) {
			super.updateObject(orderPosition);
		}
	}
	
}