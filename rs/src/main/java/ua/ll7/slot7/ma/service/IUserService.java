package ua.ll7.slot7.ma.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:55
 */
@Service
public interface IUserService extends IGService<User> {

	public User findByEMail(String email);

}
