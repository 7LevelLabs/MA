package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:55
 */
public interface IUserService {

	public void save(User toSave);

	public void delete(User toDelete);

	public boolean exist(String email);

	public User findById(long id);

	public User findByEMail(String email);

}
