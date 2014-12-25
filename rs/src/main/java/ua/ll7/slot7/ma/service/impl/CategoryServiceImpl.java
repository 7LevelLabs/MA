package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.repository.ICategoryDao;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:50
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CategoryServiceImpl implements ICategoryService  {

	@Autowired
	private ICategoryDao dao;

	@Override
	public void save(CategoryForTheUser toSave) {
		dao.save(toSave);
	}

	@Override
	public boolean existCategoryByName(User user, String categoryNameToCheck) {
		CategoryForTheUser categoryForTheUser = new CategoryForTheUser();
		categoryForTheUser.setUser(user);
		categoryForTheUser.setName(categoryNameToCheck);
		return user.getCategories().contains(categoryForTheUser);
	}
}
