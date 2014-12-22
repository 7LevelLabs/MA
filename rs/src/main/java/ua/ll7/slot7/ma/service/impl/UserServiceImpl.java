package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.dao.IUserDao;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IUserService;

import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:27
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public void save(User toSave) {
		dao.save(toSave);
	}

	@Override
	public void delete(User toDelete) {
		dao.delete(toDelete);
	}

	@Override
	public boolean exist(String email) {
		return findByEMail(email) != null;
	}

	@Override
	public User findById(long id) {
		return dao.findOne(id);
	}

	@Override
	public User findByEMail(String email) {
		List<User> users = dao.findByEmail(email);
		if (users != null) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
