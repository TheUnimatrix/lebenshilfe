package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.utils.HibernateUtils;

public class UserDao extends AbstractDao<User> {
	
	public void saveOrUpdateUser(User user) {
		if (user != null) {
			super.saveOrUpdateObject(user);
		}
	}
	
	public User getUserByUserId(Integer userId) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, userId);
		
//		tx.commit();
		session.close();
		
		return user;
	}
	
}