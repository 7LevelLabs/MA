package ua.ll7.slot7.ma.service.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.exception.AppDataIntegrityException;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.User;
import ua.ll7.slot7.ma.service.IBLService;
import ua.ll7.slot7.ma.service.ICategoryService;
import ua.ll7.slot7.ma.service.IUserService;
import ua.ll7.slot7.ma.util.MAFactory;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BLServiceTest extends Assert {

	@Autowired
	private IBLService blService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Test(expected = AppDataIntegrityException.class)
	public void testCategoryCreateException() throws Exception {
		User user = MAFactory.getNewUser("email", "nick", "name", "password");
		userService.save(user);

		CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategory(user, "Cat1", "Category1");
		CategoryForTheUser categoryForTheUser2 = MAFactory.getNewCategory(user, "Cat2", "Category2");

		categoryService.save(categoryForTheUser1);
		categoryService.save(categoryForTheUser2);

		blService.categoryCreate(user, "Cat1", "Category1");
	}

	@Test
	public void testCategoryCreate() throws Exception {
		User user = MAFactory.getNewUser("email", "nick", "name", "password");
		userService.save(user);

		CategoryForTheUser categoryForTheUser1 = MAFactory.getNewCategory(user, "Cat1", "Category1");
		CategoryForTheUser categoryForTheUser2 = MAFactory.getNewCategory(user, "Cat2", "Category2");

		categoryService.save(categoryForTheUser1);
		categoryService.save(categoryForTheUser2);

		blService.categoryCreate(user, "Cat3", "Category1");

		User userRead = userService.findByEMail("email");

		List<CategoryForTheUser> categoryForTheUserSet = userRead.getCategories();

		org.assertj.core.api.Assertions.assertThat(categoryForTheUserSet)
			.isNotEmpty()
			.hasSize(3)
			.contains(categoryForTheUser1, categoryForTheUser2)
		;

	}

}