package de.lebenshilfe.foodorder.daos;

import de.lebenshilfe.foodorder.models.FoodOrder;

public class FoodOrderDao extends AbstractDao<FoodOrder> {
	
	public void saveOrUpdateFoodOrder(FoodOrder foodOrder) {
		if (foodOrder != null) {
			
			Integer foodOrderId = foodOrder.getId();
			
			if (foodOrderId == null) {
				super.saveObject(foodOrder);
			} else {
				super.updateObject(foodOrder);
			}
		}
	}
	
}