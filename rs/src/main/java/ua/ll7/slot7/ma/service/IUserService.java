package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:55
 */
public interface IUserService {

	public void save(User toSave);

	public void delete(User toDelete);

	public boolean exist(String email);

	public List<User> findAll();

	public User findById(long id);

	public User findByEMail(String email);

}
