package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;

import de.lebenshilfe.foodorder.enums.Role;
import de.lebenshilfe.foodorder.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manager/uebersicht.html")
public class ManagerServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User)req.getSession().getAttribute("user");
		
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login.html");
			return;
		}
		
		boolean isAdmin = req.isUserInRole(Role.ADMIN.getName());
		boolean isManager = req.isUserInRole(Role.MANAGER.getName());
		
		System.out.println(isAdmin);
		System.out.println(isManager);
		
		if (isAdmin || isManager) {
			req.getRequestDispatcher("/WEB-INF/views/manager/list.jsp").forward(req, resp);
			return;
		}
		
		// TODO Umleitung auf 403-Seite
		// TODO 403-Seite erstellen
		resp.sendRedirect(req.getContextPath() + "/startseite.html");
	}
	
}