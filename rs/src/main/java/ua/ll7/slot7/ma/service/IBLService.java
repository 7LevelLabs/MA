package ua.ll7.slot7.ma.service;

import org.joda.money.CurrencyUnit;
import ua.ll7.slot7.ma.data.request.*;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;
import ua.ll7.slot7.ma.data.vo.UserVO;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;

import java.util.List;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:26
 */
public interface IBLService {

	//User
	public void userCreate(UserRegisterRequest request);

	public List<UserVO> userList();

	public List<UserVO> userListPageable(UserListPageableRequest request);

	public void userSetActive(UserSetActiveRequest request);

	public void userUpdateNickName(UserUpdateNickNameRequest request);

	//CategoryForTheUser
	public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription);

	public List<CategoryForTheUser> categoryListForTheUser(User user);

	public void categoryUpdate(CategoryUpdateRequest request);

	public boolean isCategoryBelongToTheUser(CategoryForTheUser category, User user);

	//ExpenseForCategory
	public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, float amount, String dateSign);

	public Expense expenseCreateForCategoryUSD(CategoryForTheUser category, float amount, String dateSign);

	public Expense expenseCreateForCategoryUSD(ExpenseCreateRequest request);

	public List<ExpenseVO> expenseList(ExpenseListPageableRequest request);

	//CurrencyRate
	public void currensyRateCreate(CurrensyRateCreateRequest request);

	public float currensyRateCurrent(CurrencyRateCurrentRequest request);

}
