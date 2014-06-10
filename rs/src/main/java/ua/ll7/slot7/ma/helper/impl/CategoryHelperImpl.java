package ua.ll7.slot7.ma.helper.impl;

import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.helper.ICategoryHelper;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:31
 */
@Component
public class CategoryHelperImpl implements ICategoryHelper {

	@Override
	public Category getNewCategory(User user,
					   String name,
					   String description){
		Category category = new Category();

		category.setUser(user);
		category.setName(name);
		category.setDescription(description);

		user.getCategories().add(category);

		return category;
	}
}
