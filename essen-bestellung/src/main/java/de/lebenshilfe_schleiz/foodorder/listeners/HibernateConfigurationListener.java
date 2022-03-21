package de.lebenshilfe_schleiz.foodorder.listeners;

import de.lebenshilfe_schleiz.foodorder.utils.HibernateUtils;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class HibernateConfigurationListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtils.initSessionFactory();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtils.closeSessionFactory();
	}
	
}