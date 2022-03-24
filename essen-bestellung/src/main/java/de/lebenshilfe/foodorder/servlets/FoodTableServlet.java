package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.JSONArray;
import org.json.JSONException;

import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.utils.JSONUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/startseite.html")
public class FoodTableServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Hole aktuellen Benutzer aus Session
		User user = (User)req.getSession().getAttribute("user");
		
		if (user == null) {
			// Weiterleiten auf Login-Seite und Abbrechen der Methode
			resp.sendRedirect("login.html");
			return;
		}
		
		// Holen der Preisgruppe
		Integer priceGroup = user.getPriceGroup();
		
		if (priceGroup == null) {
			// TODO Eine Alternative finden; dürfte nicht eintreffen, weil Preisgruppe = not-null
			return;
		}
		
		// Abrufen der JSON-Tabelle anhand der Preisgruppe
		JSONArray jsonArray = this.getWeeklyFoodForPriceGroup(priceGroup);
		req.setAttribute("food", jsonArray);
		
		// Anzeigen der Startseite
		req.getRequestDispatcher("/WEB-INF/views/startseite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Auslesen des Formulars
		String priceGroup = req.getParameter("price-group");

		// Falls ein Wert ausgewählt wurde, wird die URL erstellt und ausgelesen
		if (priceGroup != null) {

//			JSONArray jsonArray = this.getWeeklyFoodForPriceGroup(priceGroup);
//			req.setAttribute("food", jsonArray);
		}

		// Leite Benutzer wieder auf "startseite.jsp" weiter
		req.getRequestDispatcher("/WEB-INF/views/startseite.jsp").forward(req, resp);
	}
	
	private JSONArray getWeeklyFoodForPriceGroup(Integer priceGroup) {
		
		Calendar nextMonday = this.getNextMonday();
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String urlPrefix = "http://essen.wfbm-schleiz.local/index.php/API/plan/" + priceGroup + "/";
		
		JSONArray weeklyFood = new JSONArray();
		
		do {
			String currentDateString = sdf.format(nextMonday.getTime());
			String completeUrl = urlPrefix + currentDateString;
			
			try {
				JSONArray currentDayFood = JSONUtils.readJsonArrayFromUrl(completeUrl);
				weeklyFood.put(currentDayFood);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			nextMonday.add(Calendar.DAY_OF_WEEK, 1);
			
		} while (nextMonday.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY);
		
		return weeklyFood;
	}

	private Calendar getNextMonday() {

		// Erzeuge Calendar-Objekt mit aktuellem Datum
		Calendar nextMonday = new GregorianCalendar();

		// Wenn aktueller Tag Montag ist, dann gib das heutige Datum zurück
		if (nextMonday.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return nextMonday;
		}

		// Iteriere solange, bis Montag erreicht wurde
		do {
			nextMonday.add(Calendar.DAY_OF_WEEK, 1);
		} while (nextMonday.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY);

		// Gib den gefundenen Montag zurück
		return nextMonday;
	}

}