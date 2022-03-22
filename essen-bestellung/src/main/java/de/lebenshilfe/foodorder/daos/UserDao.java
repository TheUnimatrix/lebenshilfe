package de.lebenshilfe.foodorder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.utils.HibernateUtils;

public class UserDao extends AbstractDao<User> {
	
	public void saveOrUpdateUser(User user) {
		if (user != null) {
			super.updateObject(user);
		}
	}
	
	public User getUserByUserId(Integer userId) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		Transaction tx = session.beginTransaction();
		User user = session.byId(User.class).load(userId);
		
//		tx.commit();
		session.close();
		
		return user;
	}
	
}