package ua.ll7.slot7.ma.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IExpenseService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.math.BigDecimal;
import java.util.List;

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

	@Override
	public long userCreate(String email, String password) {
		// create new user
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		userService.save(user);

		//send emails
		return user.getId();
	}

	@Override
	public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription) {
		CategoryForTheUser categoryForTheUser = MAFactory.getNewCategoryFS(user,
												 categoryName,
												 categoryDescription);

		categoryService.save(categoryForTheUser);

		return categoryForTheUser;
	}

	@Override
	public List<CategoryForTheUser> categoryListForTheUser(User user) {
		return categoryService.findByUser(user);
	}

	@Override
	public void categoryUpdate(CategoryUpdateRequest request) {
		CategoryForTheUser categoryForTheUser = categoryService.findById(request.getData3());

		if (StringUtils.isNotBlank(request.getData1())) {
			categoryForTheUser.setName(request.getData1());
		}

		if (StringUtils.isNotBlank(request.getData2())) {
			categoryForTheUser.setName(request.getData2());
		}
	}

	@Override
	public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, double amount) {
		Expense result = MAFactory.getNewExpenseFS(category, currencyUnit, BigDecimal.valueOf(amount));
		expenseService.save(result);
		return result;
	}
}
