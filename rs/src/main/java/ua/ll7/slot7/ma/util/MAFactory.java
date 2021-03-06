package ua.ll7.slot7.ma.util;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import ua.ll7.slot7.ma.data.vo.CategoryForTheUserVO;
import ua.ll7.slot7.ma.data.vo.CurrencyRateVO;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.CurrencyRate;
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

	public static List<ExpenseVO> getExpenseVOList(List<Expense> expenses) {
		List<ExpenseVO> result = new LinkedList<>();
		for (Expense expense : expenses) {
			result.add(getExpenseVO(expense));
		}
		return result;
	}

	public static CurrencyRateVO getCurrencyRateVO(CurrencyRate currencyRate) {
		CurrencyRateVO currencyRateVO = new CurrencyRateVO();

		currencyRateVO.setCurrencyCode1(currencyRate.getCurrencyCode1());
		currencyRateVO.setCurrencyCode2(currencyRate.getCurrencyCode2());
		currencyRateVO.setRate(currencyRate.getRate());
		currencyRateVO.setRegistered(currencyRate.getRegistered().getTime());

		return currencyRateVO;
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
		user.setRole(0);

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

	public static CurrencyRate getNewCurrencyRateFS(String c1Code, String c2Code, float rate) {
		CurrencyRate currencyRate = new CurrencyRate();

		currencyRate.setCurrencyCode1(c1Code);
		currencyRate.setCurrencyCode2(c2Code);
		currencyRate.setRate(rate);

		return currencyRate;
	}

}
