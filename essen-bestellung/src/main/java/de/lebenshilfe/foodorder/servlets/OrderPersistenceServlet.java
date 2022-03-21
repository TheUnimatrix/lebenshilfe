package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;
import org.json.JSONObject;

import de.lebenshilfe.foodorder.daos.OrderPositionDao;
import de.lebenshilfe.foodorder.models.FoodOrder;
import de.lebenshilfe.foodorder.models.OrderPosition;
import de.lebenshilfe.foodorder.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderPersistenceServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JSONArray orderArray = (JSONArray)req.getSession().getAttribute("order-array");
		User currentUser = (User)req.getSession().getAttribute("user");
		
//		System.out.println(currentUser);
		
		OrderPositionDao orderPositionDao = new OrderPositionDao();
		
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setOrderDateTime(LocalDateTime.now());
		foodOrder.setUser(currentUser);
		
		
		System.out.println(orderArray);
		
		
		
		for (int i = 0; i < orderArray.length(); i++) {
			JSONObject currentOrderDay = orderArray.getJSONObject(i);
			String day = currentOrderDay.get("date").toString();
			
			JSONArray foodArray = currentOrderDay.getJSONArray("food");
			
			for (int j = 0; j < foodArray.length(); j++) {
				JSONObject currentOrder = foodArray.getJSONObject(j);
				String foodNr = currentOrder.getString("nr");
				int foodId = currentOrder.getInt("id");
				int amount = currentOrder.getInt("menge");
				double price = currentOrder.getDouble("preis");
				
				OrderPosition currentOrderPosition = new OrderPosition();
				currentOrderPosition.setFoodDate(LocalDate.parse(day));
				currentOrderPosition.setFood(foodNr);
				currentOrderPosition.setFoodId(foodId);				
				currentOrderPosition.setAmount(amount);
				currentOrderPosition.setPrice(price);
				currentOrderPosition.setFoodOrder(foodOrder);
				
				orderPositionDao.saveOrUpdateObject(currentOrderPosition);
			}
		}
		
//		FoodOrderDao foodOrderDao = new FoodOrderDao();
//		foodOrderDao.saveOrUpdateObject(foodOrder);
		
		resp.sendRedirect("startseite.html");
	}
	
}