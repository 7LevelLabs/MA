package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.repository.IUserRepository;
import ua.ll7.slot7.ma.service.IUserService;

import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:27
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Override
	public void save(User toSave) {
		repository.save(toSave);
	}

	@Override
	public void delete(User toDelete) {
		repository.delete(toDelete);
	}

	@Override
	public boolean exist(String email) {
		return findByEMail(email) != null;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public User findByEMail(String email) {
		User users = repository.findByEmail(email);
		return users;
	}
}
