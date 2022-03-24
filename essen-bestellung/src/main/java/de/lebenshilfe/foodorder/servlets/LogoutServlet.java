package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;

import de.lebenshilfe.foodorder.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout.html")
public class LogoutServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Wenn der Benutzer die Seite manuell über den Browser aufgerufen hat,
		// soll er dennoch ausgeloggt werden
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Hole aktuellen Benutzer aus Session
		User user = (User)req.getSession().getAttribute("user");
		
		// Lösche aktuellen Benutzer aus Session
		if (user != null) {
			req.getSession().setAttribute("user", null);
		}
		
		// Weiterleiten auf Login-Seite
		resp.sendRedirect("login.html");
	}
	
}