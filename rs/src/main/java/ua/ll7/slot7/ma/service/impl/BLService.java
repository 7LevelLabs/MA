package ua.ll7.slot7.ma.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppEntityNotFoundException;
import ua.ll7.slot7.ma.helper.ICategoryHelper;
import ua.ll7.slot7.ma.helper.IUserHelper;
import ua.ll7.slot7.ma.model.Category;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:27
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BLService implements IBLService {

	private static final Logger LOGGER = Logger.getLogger(BLService.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUserHelper userHelper;

	@Autowired
	private ICategoryHelper categoryHelper;

	@Override
	public User userFind(long userId) throws AppEntityNotFoundException {
		User user = userService.findById(userId);

		if (user == null) {
			LOGGER.warn("User id not found : " + userId);
			throw new AppEntityNotFoundException("User id not found : " + userId);
		}

		return user;
	}

	@Override
	public Category categoryCreate(long userId, String categoryName, String categoryDescription) throws AppEntityNotFoundException, AppDataIntegrityException {
		User user = userService.findById(userId);

		if (user == null) {
			LOGGER.warn("User id not found : " + userId);
			throw new AppEntityNotFoundException("User id not found : " + userId);
		}

		if (userHelper.existCategoryByName(user, categoryName)) {
			LOGGER.warn("Category already exists : " + categoryName + " for User : " + user.getId());
			throw new AppDataIntegrityException("Category already exists : " + categoryName + " for User : " + user.getNick());
		}

		Category category = categoryHelper.getNewCategory(user,
			categoryName,
			categoryDescription);

		userService.update(user);

		return category;
	}
}
