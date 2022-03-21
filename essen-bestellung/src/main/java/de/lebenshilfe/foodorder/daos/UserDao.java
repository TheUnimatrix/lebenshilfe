package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.utils.HibernateUtils;

public class UserDao {
	
	public void insertUser(User user) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	
}