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
		
		// Hole aktuellen Benutzer aus der Session, sofern einer angemeldet ist
		User user = (User)req.getSession().getAttribute("user");
		
		if (user == null) {
			// Anzeigen der Login-Seite und Abbrechen der Methode
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}
		
		// Weiterleitung auf Startseite
//		req.getRequestDispatcher("/WEB-INF/views/startseite.jsp").forward(req, resp);
		resp.sendRedirect("startseite.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// Hole Benutzer anhand seiner E-Mail-Adresse aus der DB
		User user = userDao.getUserByEmail(email);
		
		// Überprüfe, ob Benutzer gefunden wurde
		if (user == null) {
			// TODO Abbruch bzw. Fehlermeldung generieren
			System.out.println("=== Unter der Adresse " + email + " wurde niemand gefunden");

			// Weiterleitung auf Login-Seite
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			return;
		}
		
		boolean pwdCorrect = PasswordUtils.validatePassword(password, user.getPassword());
		
		if (pwdCorrect) {
//			System.out.println("=== Alles gut");

			// TODO Benutzer in Session hinterlegen
//				req.authenticate(resp);
			req.getSession().setAttribute("user", user);

			// Weiterleitung auf Login-Seite
//			req.getRequestDispatcher("/WEB-INF/views/startseite.jsp").forward(req, resp);
			resp.sendRedirect("startseite.html");
			return;
		}
		
		// TODO Abbruch bzw. Fehlermeldung generieren
		// Weiterleitung auf Login-Seite
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}

}