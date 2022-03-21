package de.lebenshilfe_schleiz.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.lebenshilfe_schleiz.foodorder.models.Address;
import de.lebenshilfe_schleiz.foodorder.utils.HibernateUtils;

public class AddressDao {

	public void saveOrUpdateAddress(Address address) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(address);
		tx.commit();
	}

}