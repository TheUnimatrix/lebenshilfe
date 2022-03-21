package de.lebenshilfe_schleiz.foodorder.servlets;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FoodDetailsServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Umleitung auf Startseite, weil diese Seite nicht direkt aufgerufen werden sollte
		resp.sendRedirect("startseite.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSON-Array für die komplette Bestellung des Kunden
		JSONArray completeOrderArray = new JSONArray();
		
		// Lies die Daten aus der Tabelle zeilenweise aus und erstelle daraus ein JSON-Objekt
		for (int i = 0; i < 5; i++) {
			
			String date = req.getParameter("date-" + i);
			
			// Überspringe, wenn kein Datum gefunden wurde
			if (date == null) {
				continue;
			}
			
			JSONObject completeDailyOrder = new JSONObject();
			JSONArray dailyOrderArray = new JSONArray();
			
			for (int j = 0; j < 3; j++) {
				
				// Hole benötigte Angaben
				String foodNumber = req.getParameter("food-nr-" + i + "-" + j);
				String foodText = req.getParameter("food-text-" + i + "-" + j);
				String foodId = req.getParameter("food-id-" + i + "-" + j);
				String price = req.getParameter("price-" + i + "-" + j);
				String amount = req.getParameter("amount-" + i + "-" + j);
				
				// Überspringe, wenn mindestens eine Angabe "null" ist
				if (foodNumber == null || foodText == null || foodId == null || price == null || amount == null) {
					continue;
				}
				
				int iAmount = Integer.parseInt(amount);
				
				// Überspringe Einträge, bei denen die Einzelmenge = 0 ist
				if (iAmount == 0) {
					continue;
				}
				
				price = price.replace(",", ".");
				
				JSONObject orderSingleMeal = new JSONObject();
				orderSingleMeal.put("nr", foodNumber);
				orderSingleMeal.put("essen", foodText);
				orderSingleMeal.put("id", foodId);
				orderSingleMeal.put("preis", price);
				orderSingleMeal.put("menge", amount);
				
				dailyOrderArray.put(orderSingleMeal);
			}
			
			if (!dailyOrderArray.isEmpty()) {
				completeDailyOrder.put("date", date);
				completeDailyOrder.put("food", dailyOrderArray);
				completeOrderArray.put(completeDailyOrder);
			}
		}
		
		//System.out.println(completeOrderArray);
		
		// Setze Bestellung in Request
		req.setAttribute("order-array", completeOrderArray);
		
		// Zeige Übersichtsseite an
		req.getRequestDispatcher("/WEB-INF/views/overview.jsp").forward(req, resp);
	}
	
}