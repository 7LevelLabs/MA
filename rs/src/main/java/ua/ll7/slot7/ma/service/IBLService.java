package ua.ll7.slot7.ma.service;

import org.joda.money.CurrencyUnit;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.exception.AppEntityNotFoundException;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;

import java.math.BigDecimal;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:26
 */
public interface IBLService {
  //CategoryForTheUser
  public CategoryForTheUser categoryCreateForUser(User user, String categoryName, String categoryDescription) throws AppEntityNotFoundException, AppDataIntegrityException;

  //ExpenseForCategory
  public Expense expenseCreateForCategory(CategoryForTheUser category, CurrencyUnit currencyUnit, double amount);
}
