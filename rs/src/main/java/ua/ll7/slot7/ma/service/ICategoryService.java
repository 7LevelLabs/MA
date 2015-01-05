package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:49
 */
public interface ICategoryService {
	public void save(CategoryForTheUser toSave);

	public boolean existCategoryByName(User user, String categoryNameToCheck);

	public CategoryForTheUser findByUserAndName(User user, String categoryName);

	public List<CategoryForTheUser> findByUser(User user);

	public CategoryForTheUser findById(long id);

	public List<String> findPopularNames(long popIndex);

	public void update(CategoryForTheUser category);

	public boolean exist(long id);
}
