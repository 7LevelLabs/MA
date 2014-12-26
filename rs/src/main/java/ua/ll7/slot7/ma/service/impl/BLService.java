package ua.ll7.slot7.ma.service.impl;

import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppEntityNotFoundException;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IExpenseService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.math.BigDecimal;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:27
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BLService implements IBLService {

	private static final Logger LOGGER = Logger.getLogger(BLService.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IExpenseService expenseService;

	public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription) throws AppEntityNotFoundException, AppDataIntegrityException {

		if (categoryService.existCategoryByName(user, categoryName)) {
			LOGGER.warn("CategoryForTheUser already exists : " + categoryName + " for User : " + user.getId());
			throw new AppDataIntegrityException("CategoryForTheUser already exists : " + categoryName + " for User : " + user.getNick());
		}

		CategoryForTheUser categoryForTheUser = MAFactory.getNewCategory(user,
			categoryName,
			categoryDescription);

		categoryService.save(categoryForTheUser);

		return categoryForTheUser;
	}

	@Override
	public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, double amount) {
		Expense result = MAFactory.getNewExpense(category, currencyUnit, BigDecimal.valueOf(amount));
		expenseService.save(result);
		return result;
	}
}
