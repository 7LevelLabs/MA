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

	public List<User> findAllPageable(int data1, int data2);

	public User findById(long id);

	public User findByEMail(String email);
}
