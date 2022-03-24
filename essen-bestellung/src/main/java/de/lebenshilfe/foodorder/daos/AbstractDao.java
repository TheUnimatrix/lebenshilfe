package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.lebenshilfe.foodorder.utils.HibernateUtils;
import jakarta.persistence.PersistenceException;

public abstract class AbstractDao<T> {
	
	protected void saveObject(T object) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
//			session.saveOrUpdate(persistableObject);
			session.persist(object);
			session.flush();
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println(e);
		} finally {
			session.close();
		}
	}
	
	protected void updateObject(T object) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
//			session.saveOrUpdate(persistableObject);
			session.merge(object);
			session.flush();
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
//			System.out.println(e);
		} finally {
			session.close();
		}
	}
	
	protected T getObjectById(Class<T> objectClass, Integer objectId) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		T object = null;
		
		try {
			object = session.byId(objectClass).load(objectId);
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return object;
	}
	
}