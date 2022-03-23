package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;

import de.lebenshilfe.foodorder.daos.UserDao;
import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.utils.PasswordUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.html")
public class LoginServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO Benutzer aus Session holen, um zu überprüfen, ob es bereits einen angemeldeten Benutzer gibt
		
		// Weiterleitung auf Login-Seite
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
//		System.out.println(email);
//		System.out.println(password);
		
		// TODO Erst Benutzer aus DB holen
		// TODO Danach eingegebenes pwd verschlüsseln und vergleichen (zusammen mit Prüfsumme)
		
		User user = userDao.getUserByEmail(email);
		
		if (user == null) {
			// TODO Abbruch bzw. Fehlermeldung generieren
			System.out.println("=== Unter der Adresse " + email + " wurde niemand gefunden");
			
			// Weiterleitung auf Login-Seite
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		} else {
			String hashPwd = PasswordUtils.encodePassword(password);
			String storedPwd = user.getPassword();
			
			if (storedPwd != null && storedPwd.equals(hashPwd)) {
				System.out.println("=== Alles gut");
				
				// TODO Benutzer in Session hinterlegen
//				req.authenticate(resp);
//				req.getSession().setAttribute("user", user);
			}
			
			// Weiterleitung auf Login-Seite
			req.getRequestDispatcher("/WEB-INF/views/startseite.jsp").forward(req, resp);
		}
	}
	
}