package de.lebenshilfe.foodorder.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import de.lebenshilfe.foodorder.daos.UserDao;
import de.lebenshilfe.foodorder.models.Address;
import de.lebenshilfe.foodorder.models.User;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static void initSessionFactory() {
		if (getSessionFactory() == null) {
			Configuration cfg = new Configuration();
			cfg.setPhysicalNamingStrategy(
					new CamelCaseToUnderscoresNamingStrategy());
			cfg = cfg.configure();

			sessionFactory = cfg.buildSessionFactory();
		}
		
		
		Address addr1 = new Address();
		addr1.setStreet("Komtursteig 6");
		addr1.setPostalCode("07907");
		addr1.setCity("Schleiz");
		
		Address addr2 = new Address();
		addr2.setStreet("Augasse 10");
		addr2.setPostalCode("07907");
		addr2.setCity("Schleiz");
		
		Address addr3 = new Address();
		addr3.setStreet("Löhmaer Weg 6");
		addr3.setPostalCode("07907");
		addr3.setCity("Schleiz");
		
		Address addr4 = new Address();
		addr4.setStreet("Geraer Straße 24c");
		addr4.setPostalCode("07907");
		addr4.setCity("Schleiz");
		
		User c1 = new User();
		c1.setName("Tagesstätte Schleiz");
		c1.setEmail("ts-scz@example.com");
		c1.setDeliveryAddress(addr2);
		c1.setBillingAddress(addr1);
		
		User c2 = new User();
		c2.setName("Schleizer Werkstätten gGmbH");
		c2.setEmail("wfbm-scz@example.com");
		c2.setDeliveryAddress(addr1);
		c2.setBillingAddress(addr1);
		
		UserDao cDao = new UserDao();
		cDao.insertUser(c1);
		cDao.insertUser(c2);
		
//		AddressDao addrDao = new AddressDao();
//		addrDao.saveOrUpdateAddress(addr1);
//		addrDao.saveOrUpdateAddress(addr1);
//		addrDao.saveOrUpdateAddress(addr2);
//		addrDao.saveOrUpdateAddress(addr3);
//		addrDao.saveOrUpdateAddress(addr4);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

}