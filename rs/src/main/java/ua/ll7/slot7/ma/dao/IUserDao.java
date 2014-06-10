package ua.ll7.slot7.ma.dao;

import org.springframework.stereotype.Repository;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:35
 */

/**
 * User-specific DAO-staff
 */
@Repository
public interface IUserDao extends IGDao<User> {

	public User findByEMail(String email);

}