package ua.ll7.slot7.ma.helper.impl;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.helper.ICategoryHelper;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:31
 */
@Component
public class CategoryHelperImpl implements ICategoryHelper {

	@Override
	public CategoryForTheUser getNewCategory(User user,
					   String name,
					   String description){
		CategoryForTheUser categoryForTheUser = new CategoryForTheUser();

		categoryForTheUser.setUser(user);
		categoryForTheUser.setName(name);
		categoryForTheUser.setDescription(description);

		user.getCategories().add(categoryForTheUser);

		return categoryForTheUser;
	}
}
