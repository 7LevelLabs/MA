package ua.ll7.slot7.ma.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IExpenseService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;
import ua.ll7.slot7.ma.util.builder.ExpenseBuilder;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:maTestConf/maConfigTest.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ExpenseServiceImplTest {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IExpenseService expenseService;

	@Test
	public void testFindByCategoryPageable() throws Exception {
		User user2 = MAFactory.getNewUserForTestsFS("email2", "nick2", "name2", "password2");
		userService.save(user2);

		CategoryForTheUser categoryForTheUser3 = MAFactory.getNewCategoryFS(user2, "Cat3", "Category3");
		categoryService.save(categoryForTheUser3);

		CategoryForTheUser categoryForTheUser4 = MAFactory.getNewCategoryFS(user2, "Cat4", "Category4");
		categoryService.save(categoryForTheUser4);

		Expense expense41 = new ExpenseBuilder(categoryForTheUser4,
												 41.01F)
												 .build();
		expenseService.save(expense41);

		Expense expense42 = new ExpenseBuilder(categoryForTheUser4,
												 42.01F)
												 .build();
		expenseService.save(expense42);

		Expense expense43 = new ExpenseBuilder(categoryForTheUser4,
												 43.01F)
												 .build();
		expenseService.save(expense43);

		List<Expense> expenseVOs = expenseService.findByCategoryPageable(categoryForTheUser4,
												 1,
												 2);

		org.assertj.core.api.Assertions.assertThat(expenseVOs)
												 .isNotEmpty()
												 .hasSize(2)
												 .contains(expense41, expense42)
		;

		expenseVOs = expenseService.findByCategoryPageable(categoryForTheUser3,
												 1,
												 2);

		org.assertj.core.api.Assertions.assertThat(expenseVOs)
												 .isEmpty()
		;

	}
}