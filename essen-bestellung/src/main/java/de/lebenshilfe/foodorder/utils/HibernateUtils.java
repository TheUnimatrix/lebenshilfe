package de.lebenshilfe.foodorder.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;

import de.lebenshilfe.foodorder.daos.AddressDao;
import de.lebenshilfe.foodorder.daos.UserDao;
import de.lebenshilfe.foodorder.models.Address;
import de.lebenshilfe.foodorder.models.FoodOrder;
import de.lebenshilfe.foodorder.models.OrderPosition;
import de.lebenshilfe.foodorder.models.Role;
import de.lebenshilfe.foodorder.models.User;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static void initSessionFactory() throws ServiceException {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.setPhysicalNamingStrategy(
					new CamelCaseToUnderscoresNamingStrategy());
			
			// Hinzufügen der Hibernate-Mappings (per Annotations)
			cfg.addAnnotatedClass(Address.class);
			cfg.addAnnotatedClass(FoodOrder.class);
			cfg.addAnnotatedClass(OrderPosition.class);
			cfg.addAnnotatedClass(Role.class);
			cfg.addAnnotatedClass(User.class);
			
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
		
		Address addr5 = new Address();
		addr5.setStreet("Löhmaer Weg 13");
		addr5.setPostalCode("07907");
		addr5.setCity("Schleiz");
		
		Role user = new Role();
		user.setName("user");
		
		Role admin = new Role();
		admin.setName("admin");
		
		Role manager = new Role();
		manager.setName("manager");
		
		User c1 = new User();
		c1.setName("Tagesstätte Schleiz");
		c1.setEmail("ts-scz@example.com");
		c1.setDeliveryAddress(addr2);
		c1.setBillingAddress(addr1);
		c1.setRole(user);
		
		User c2 = new User();
		c2.setName("Schleizer Werkstätten gGmbH");
		c2.setEmail("wfbm-scz@example.com");
		c2.setDeliveryAddress(addr1);
		c2.setBillingAddress(addr1);
		c2.setRole(user);
		
		User c3 = new User();
		c3.setName("Sebastian");
		c3.setEmail("segi@example.com");
		c3.setDeliveryAddress(addr5);
		c3.setBillingAddress(addr5);
		c3.setRole(admin);
		
		UserDao cDao = new UserDao();
		cDao.saveOrUpdateUser(c1);
		cDao.saveOrUpdateUser(c2);
		cDao.saveOrUpdateUser(c3);
		
		AddressDao addrDao = new AddressDao();
//		addrDao.saveOrUpdateAddress(addr1);
//		addrDao.saveOrUpdateAddress(addr1);
//		addrDao.saveOrUpdateAddress(addr2);
		addrDao.saveOrUpdateAddress(addr3);
		addrDao.saveOrUpdateAddress(addr4);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}