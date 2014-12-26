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

  private MAFactory() {

  }

  public static User getNewUser(String email,
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

  public static CategoryForTheUser getNewCategory(User user,
                                                  String name,
                                                  String description) {
    CategoryForTheUser categoryForTheUser = new CategoryForTheUser();

    categoryForTheUser.setUser(user);
    categoryForTheUser.setName(name);
    categoryForTheUser.setDescription(description);

    user.getCategories().add(categoryForTheUser);

    return categoryForTheUser;
  }

  private static Expense getNewExpenseUSD(CategoryForTheUser category, BigDecimal amount) {
    return getNewExpense(category, CurrencyUnit.USD, amount);
  }

  private static Expense getNewExpense(CategoryForTheUser category, CurrencyUnit cu, BigDecimal amount) {
    Expense result = new Expense();

    result.setCategoryForTheUser(category);
    Money amountMoney = Money.of(cu, amount);
    result.setExpenseAmount(amountMoney);

    return result;
  }

}
