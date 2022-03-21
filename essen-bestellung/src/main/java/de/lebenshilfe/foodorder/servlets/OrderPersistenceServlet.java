package de.lebenshilfe.foodorder.servlets;

import java.io.IOException;

import de.lebenshilfe.foodorder.daos.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderPersistenceServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("startseite.html");
	}
	
}