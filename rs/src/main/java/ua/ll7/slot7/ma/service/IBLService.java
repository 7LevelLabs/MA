package ua.ll7.slot7.ma.service;

import org.joda.money.CurrencyUnit;
import ua.ll7.slot7.ma.data.request.CategoryUpdateRequest;
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
  public long userCreate(String email, String password);

  //CategoryForTheUser
  public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription);

  public List<CategoryForTheUser> categoryListForTheUser(User user);

  public void categoryUpdate(CategoryUpdateRequest request);

  //ExpenseForCategory
  public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, double amount);
}
