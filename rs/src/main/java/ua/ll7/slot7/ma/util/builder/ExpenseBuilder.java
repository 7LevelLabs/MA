package ua.ll7.slot7.ma.util.builder;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MA
 * Velichko A.
 * 30.12.14 17:01
 */
public class ExpenseBuilder {
  private Expense data;

  public ExpenseBuilder(CategoryForTheUser category,
                        double amount) {
    data = new Expense();
    data.setCategoryForTheUser(category);

    CurrencyUnit cu = CurrencyUnit.USD;

    BigDecimal tt = BigDecimal.valueOf(amount).setScale(cu.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);
    data.setExpenseAmount(Money.of(cu, tt));
    data.setRegistered(new Date());
  }

  public ExpenseBuilder withAmount(CurrencyUnit cu, double amount) {
    BigDecimal tt = BigDecimal.valueOf(amount).setScale(cu.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);

    data.setExpenseAmount(Money.of(cu, tt));
    return this;
  }

  public ExpenseBuilder withAmountUSD(double amount) {
    CurrencyUnit cu = CurrencyUnit.USD;
    BigDecimal tt = BigDecimal.valueOf(amount).setScale(cu.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);

    data.setExpenseAmount(Money.of(cu, tt));
    return this;
  }

  public ExpenseBuilder withActionDateSign(String actionDateSign) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date actionDate = new Date();

    try {
      actionDate = formatter.parse(actionDateSign);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    data.setActionDate(actionDate);
    return this;
  }

  public Expense build() {
    return data;
  }
}
