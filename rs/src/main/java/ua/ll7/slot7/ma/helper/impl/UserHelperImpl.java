package ua.ll7.slot7.ma.helper.impl;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;

import java.util.Set;
import java.util.UUID;

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
				  String password){
		User user = new User();

		user.setEmail(email);
		user.setNick(nick);
		user.setName(name);
		user.setPassword(password);

		UUID uuid = UUID.randomUUID();

		user.setApiCode(uuid.toString());
		return user;

	}

	@Override
	public boolean existCategoryByName(User user, String nameToCheck) {
		boolean result = true;

		Category categoryToCheck = new Category();
		categoryToCheck.setUser(user);
		categoryToCheck.setName(nameToCheck);

		Set<Category> categorySet = user.getCategories();

		return categorySet.contains(categoryToCheck);
	}
}
