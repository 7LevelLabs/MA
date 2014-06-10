package ua.ll7.slot7.ma.helper;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:38
 */
@Component
public interface IUserHelper {
	public User getNewUser(String email,
			  String nick,
			  String name,
			  String password);

	boolean existCategoryByName(User user, String nameToCheck);
}
