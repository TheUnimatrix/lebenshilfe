package de.lebenshilfe.foodorder.listeners;

import org.hibernate.service.spi.ServiceException;

import de.lebenshilfe.foodorder.utils.HibernateUtils;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HibernateConfigurationListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			HibernateUtils.initSessionFactory();
		} catch (ServiceException e) {
			System.out.println(e);
//			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtils.closeSessionFactory();
	}
	
}