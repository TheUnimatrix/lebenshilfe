package de.lebenshilfe.foodorder.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.lebenshilfe.foodorder.models.User;
import de.lebenshilfe.foodorder.models.User_;
import de.lebenshilfe.foodorder.utils.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserDao extends AbstractDao<User> {
	
	public void saveOrUpdateUser(User user) {
		if (user != null) {
			
			Integer userId = user.getId();
			
			if (userId == null) {
				super.saveObject(user);
			} else {
				super.updateObject(user);
			}
		}
	}
	
	public User getUserByUserId(Integer userId) {
		User user = null;
		
		if (userId != null) {
			user = super.getObjectById(User.class, userId);
		}
		
		return user;
	}
	
	public User getUserByEmail(String email) {
		
		if (email == null) {
			return null;
		}
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = null;
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		
		Root<User> root = query.from(User.class);
		query.where(builder.equal(root.get(User_.email), email));
		
		List<User> users = session.createQuery(query).getResultList();
		
		// Wenn Benutzer gefunden wurde, soll dieser ausgelesen werden
		if (users.size() > 0) {
			user = users.get(0);
		}
		
		// Gib den (gefundenen) Benutzer zurück
		return user;
	}
	
}