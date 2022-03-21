package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.lebenshilfe.foodorder.models.Address;
import de.lebenshilfe.foodorder.utils.HibernateUtils;

public class AddressDao {

	public void saveOrUpdateAddress(Address address) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(address);
		tx.commit();
		
		session.close();
	}

}