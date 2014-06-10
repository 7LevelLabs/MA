package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.dao.IUserDao;
import ua.ll7.slot7.ma.dao.impl.UserDaoImpl;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.AService;
import ua.ll7.slot7.ma.service.IUserService;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:27
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl extends AService<User> implements IUserService {

	@Autowired
	public void setDao(UserDaoImpl daoToSet) {
		this.dao = daoToSet;
		daoToSet.setClazz(User.class);
	}

	@Override
	public User findByEMail(String email) {
		return ((IUserDao) dao).findByEMail(email);
	}
}
