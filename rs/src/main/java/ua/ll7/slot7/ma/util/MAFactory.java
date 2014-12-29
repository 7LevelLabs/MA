package ua.ll7.slot7.ma.util;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.UUID;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:31
 */
public class MAFactory {

	//User < - > VO

	//CategoryForTheUser < - > VO

	//Expense < - > VO


	private MAFactory() {
	}

	public static User getNewUserForTestsFS(String email,
																					String nick,
																					String name,
																					String password) {
		User user = new User();

		user.setEmail(email);
		user.setNick(nick);
		user.setName(name);
		user.setPassword(password);

		UUID uuid = UUID.randomUUID();

		user.setApiCode(uuid.toString());
		user.setCategories(new LinkedList<CategoryForTheUser>());
		return user;

	}

	public static CategoryForTheUser getNewCategoryFS(User user,
																										String name,
																										String description) {
		CategoryForTheUser categoryForTheUser = new CategoryForTheUser();

		categoryForTheUser.setUser(user);
		categoryForTheUser.setName(name);
		categoryForTheUser.setDescription(description);

		user.getCategories().add(categoryForTheUser);

		return categoryForTheUser;
	}

	public static Expense getNewExpenseUSD(CategoryForTheUser category,
																				 BigDecimal amount) {
		return getNewExpenseFS(category, CurrencyUnit.USD, amount);
	}

	public static Expense getNewExpenseFS(CategoryForTheUser category,
																				CurrencyUnit cu,
																				BigDecimal amount) {
		Expense result = new Expense();

		result.setCategoryForTheUser(category);
		BigDecimal t = amount.setScale(cu.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);
		Money amountMoney = Money.of(cu, t);
		result.setExpenseAmount(amountMoney);

		category.getExpenses().add(result);

		return result;
	}

}
