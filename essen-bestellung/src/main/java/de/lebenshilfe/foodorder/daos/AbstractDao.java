package de.lebenshilfe.foodorder.daos;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import de.lebenshilfe.foodorder.utils.HibernateUtils;

public abstract class AbstractDao<T> {
	
	public void saveOrUpdateObject(T persistableObject) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.saveOrUpdate(persistableObject);
			tx.commit();
		} catch (ConstraintViolationException cve) {
			tx.rollback();
//			cve.printStackTrace();
			System.out.println(cve);
		} catch (MappingException me) {
			tx.rollback();
//			me.printStackTrace();
			System.out.println(me);
		} finally {
			session.close();
		}
	}
	
}