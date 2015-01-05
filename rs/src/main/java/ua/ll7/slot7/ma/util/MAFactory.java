package ua.ll7.slot7.ma.util;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import ua.ll7.slot7.ma.data.vo.CategoryForTheUserVO;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Alex Velichko
 *         10.06.14 : 14:31
 */
public class MAFactory {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private MAFactory() {
	}

	//User < - > VO

	public static UserVO getUserVO(User user) {
		UserVO userVO = new UserVO();

		userVO.setId(user.getId());
		userVO.setEmail(user.getEmail());
		userVO.setName(user.getName());
		userVO.setNick(user.getNick());
		userVO.setActive(user.isActive());

		return userVO;
	}

	public static List<UserVO> getUserVOList(List<User> users) {
		List<UserVO> result = new LinkedList<>();
		for (User user : users) {
			result.add(getUserVO(user));
		}
		return result;
	}

	//CategoryForTheUser < - > VO

	public static List<CategoryForTheUserVO> getCategoryForTheUserVOList(List<CategoryForTheUser> categoryForTheUsers) {
		List<CategoryForTheUserVO> result = new LinkedList<>();
		for (CategoryForTheUser categoryForTheUser : categoryForTheUsers) {
			result.add(getCategoryForTheUserVO(categoryForTheUser));
		}
		return result;
	}

	public static CategoryForTheUserVO getCategoryForTheUserVO(CategoryForTheUser category) {
		CategoryForTheUserVO categoryVO = new CategoryForTheUserVO();

		categoryVO.setId(category.getId());
		categoryVO.setUserId(category.getUser().getId());
		categoryVO.setName(category.getName());
		categoryVO.setDescription(category.getDescription());

		return categoryVO;
	}

	//Expense < - > VO

	public static ExpenseVO getExpenseVO(Expense expense) {
		ExpenseVO expenseVO = new ExpenseVO();

		expenseVO.setId(expense.getId());
		expenseVO.setCategoryForTheUserId(expense.getCategoryForTheUser().getId());
		expenseVO.setExpenseAmountCurrencySign(expense.getExpenseAmount().getCurrencyUnit().getCurrencyCode());
		expenseVO.setExpenseAmountValue((expense.getExpenseAmount().getAmount()).floatValue());
		expenseVO.setDescription(expense.getDescription());
		expenseVO.setActionDateSign(DATE_FORMAT.format(expense.getActionDate()));
		expenseVO.setRegistered(expense.getRegistered().getTime());

		return expenseVO;
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
