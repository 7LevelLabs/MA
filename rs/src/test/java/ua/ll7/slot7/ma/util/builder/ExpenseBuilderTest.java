package ua.ll7.slot7.ma.util.builder;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;

import static org.junit.Assert.assertEquals;

public class ExpenseBuilderTest {

  @Test
  public void testBuild() throws Exception {
    CategoryForTheUser category = new CategoryForTheUser();

    Expense expense = new ExpenseBuilder(category, 10.00F)
                         .withAmountUSD(20F)
                         .withActionDateSign("30-12-2014")
                         .build();

    assertEquals(expense.getExpenseAmount(), Money.of(CurrencyUnit.USD, 20));
    
  }
}