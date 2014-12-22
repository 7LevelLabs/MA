package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.User;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:49
 */
public interface ICategoryService {
	boolean existCategoryByName(User user, String categoryNameToCheck);
}
