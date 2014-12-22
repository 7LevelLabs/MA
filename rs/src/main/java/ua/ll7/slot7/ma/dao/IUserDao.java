package ua.ll7.slot7.ma.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:35
 */

/**
 * User-specific DAO-staff
 */
public interface IUserDao extends CrudRepository<User, Long> {
	public List<User> findByEmail(String toFind);
}
