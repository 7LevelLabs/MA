package ua.ll7.slot7.ma.dao.impl;

import org.hibernate.Query;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.ll7.slot7.ma.dao.ADao;
import ua.ll7.slot7.ma.dao.IUserDao;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:58
 */
@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserDaoImpl extends ADao<User> implements IUserDao {

	@Override
	public User findByEMail(String email) {

		User user = null;

		String selectString =
			"select user " +
				"from User as user " +
				"where user.email like :em";

		Query query = getCurrentSession().createQuery(selectString);
		query.setParameter("em", email);

		user = (User) query.uniqueResult();

		return user;
	}
}
