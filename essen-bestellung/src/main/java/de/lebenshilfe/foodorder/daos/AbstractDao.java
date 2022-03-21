package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.lebenshilfe.foodorder.utils.HibernateUtils;

public abstract class AbstractDao<T> {
	
	public void saveOrUpdateObject(T persistableObject) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(persistableObject);
		tx.commit();
		
		session.close();
	}
	
}