package ua.ll7.slot7.ma.helper.impl;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;

import java.util.LinkedList;

/**
 * @author Alex Velichko
 *         09.06.14 : 18:48
 */
@Component
public class UserHelperImpl implements IUserHelper {

	@Override
	public User getNewUser(String email,
				  String nick,
				  String name,
				  String password,
				  String apiCode){
		User user = new User();

		user.setEmail(email);
		user.setNick(nick);
		user.setName(name);
		user.setPassword(password);
		user.setApiCode(apiCode);

		user.setCategories(new LinkedList<Category>());

		return user;

	}

}
